package teamkunle.co.uk.arcoresample.rendering

import android.content.Context
import android.opengl.GLES20
import android.opengl.Matrix
import com.google.ar.core.PointCloud
import com.google.ar.core.Pose
import teamkunle.co.uk.arcoresample.R


class PointCloudRenderer {

    companion object {
        private const val TAG = "PointCloudRenderer"
        private const val BYTES_PER_FLOAT       = 32 / 8
        private const val FLOATS_PER_POINT      = 4
        private const val BYTES_PER_POINT       = BYTES_PER_FLOAT * FLOATS_PER_POINT
        private const val INITIAL_BUFFER_POINTS = 1000
    }

    private var vbo : Int = 0
    private var vboSize : Int = 0

    private var programmeName : Int = 0
    private var positionAttribute : Int = 0
    private var modelViewProjectionUniform : Int = 0
    private var colorUniform : Int = 0
    private var pointSizeUniform : Int = 0

    private var numPoints : Int = 0

    private lateinit var lastPointCloud : PointCloud

    fun createOnGlThread(context : Context) {
        ShaderUtils.checkGLError(TAG, "before we create")

        var buffers = IntArray(1)
        GLES20.glGenBuffers(1, buffers, 0)
        vbo = buffers[0]
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo)

        vboSize = INITIAL_BUFFER_POINTS * BYTES_PER_POINT
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, vboSize, null, GLES20.GL_DYNAMIC_DRAW)
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0)

        ShaderUtils.checkGLError(TAG, "buffer alloc")

        var vertexShader : Int = ShaderUtils.loadGlShader(TAG, context,
                GLES20.GL_VERTEX_SHADER,
                R.raw.point_cloud_vertex)

        var passThroughShader : Int = ShaderUtils.loadGlShader(TAG, context,
                GLES20.GL_FRAGMENT_SHADER,
                R.raw.passthrough_fragment)

        programmeName = GLES20.glCreateProgram()
        GLES20.glAttachShader(programmeName, vertexShader)
        GLES20.glAttachShader(programmeName, passThroughShader)
        GLES20.glLinkProgram(programmeName)
        GLES20.glUseProgram(programmeName)

        ShaderUtils.checkGLError(TAG, "program")

        positionAttribute          = GLES20.glGetAttribLocation(programmeName, "a_position")
        colorUniform               = GLES20.glGetUniformLocation(programmeName, "u_color")
        modelViewProjectionUniform = GLES20.glGetUniformLocation(programmeName, "u_ModelViewProjection")
        pointSizeUniform           = GLES20.glGetUniformLocation(programmeName, "u_PointSize")

        ShaderUtils.checkGLError(TAG, "program params")

    }

    /*
    * Updates the OpenGL buffer contents to the provided point. Repeated calls with same point cloud
    * will be ignored
    * */
    fun update(cloud : PointCloud) {
        if (lastPointCloud == cloud) return

        ShaderUtils.checkGLError(TAG, "before update")

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo)
        lastPointCloud = cloud

        numPoints = lastPointCloud.points.remaining() / FLOATS_PER_POINT

        if (numPoints * BYTES_PER_POINT > vboSize) {
            while (numPoints * BYTES_PER_POINT > vboSize) {
                vboSize *= 2
            }
            GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, vboSize, null, GLES20.GL_DYNAMIC_DRAW)
        }
        GLES20.glBufferSubData(GLES20.GL_ARRAY_BUFFER, 0, numPoints * BYTES_PER_POINT,
                lastPointCloud.points)
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0)
        ShaderUtils.checkGLError(TAG, "after update")
    }

    /**
     * Renders the point cloud
     * */
    fun draw(pose : Pose, cameraView : FloatArray, cameraPerspective : FloatArray) {
        var modelmatrix = FloatArray(16)
        pose.toMatrix(modelmatrix, 0)

        var modelView = FloatArray(16)
        var modelViewProjection = FloatArray(16)
        Matrix.multiplyMM(modelView, 0, cameraView, 0, modelmatrix, 0)
        Matrix.multiplyMM(modelViewProjection, 0, cameraPerspective, 0, modelView, 0)

        ShaderUtils.checkGLError(TAG, "before draw")

        GLES20.glUseProgram(programmeName)
        GLES20.glEnableVertexAttribArray(positionAttribute)
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo)
        GLES20.glVertexAttribPointer(positionAttribute, 4, GLES20.GL_FLOAT, false, BYTES_PER_POINT, 0)

        GLES20.glUniform4f(colorUniform, 31.0f / 255.0f, 188.0f / 255.0f, 210.0f / 255.0f, 1.0f)
        GLES20.glUniformMatrix4fv(modelViewProjectionUniform, 1, false, modelViewProjection, 0)
        GLES20.glUniform1f(pointSizeUniform, 5.0f)

        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, numPoints)
        GLES20.glDisableVertexAttribArray(positionAttribute)
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0)

        ShaderUtils.checkGLError(TAG, "Draw")
    }
}