package teamkunle.co.uk.arcoresample.rendering

import android.content.Context
import android.opengl.GLES20
import com.google.ar.core.PointCloud


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

    private var numPoints : Int = 0

    private lateinit var lastPointCloud : PointCloud

    fun createOnGlThread(context : Context) {
        ShaderUtils.checkGLError(TAG, "before we create")

        var buffers = IntArray(1)
        GLES20.glGenBuffers(1, buffers, 0)
        vbo = buffers[0]
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo)

//        vboSize
    }


}