package teamkunle.co.uk.arcoresample.rendering

import android.content.Context
import android.opengl.GLES20
import android.util.Log

class ShaderUtils {
    companion object {
        @JvmStatic
        fun loadGlShader(tag : String, context : Context,type : Int ,resId : Int) : Int {
            val code  = readRawTextFile(context, resId)
            var shader = GLES20.glCreateShader(type)
            GLES20.glShaderSource(shader, code)
            GLES20.glCompileShader(shader)

            val compileStatus = IntArray(1)
            GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compileStatus, 0)

            if (compileStatus[0] == 0) {
                Log.e(tag, "Error compiling shader : " + GLES20.glGetShaderInfoLog(shader))
                GLES20.glDeleteShader(shader)
                shader = 0
            }

            if (shader == 0) {
                throw RuntimeException("error creating shader.")
            }

            return shader
        }

        @JvmStatic
        fun readRawTextFile(context: Context, resId : Int) : String {

            return ""
        }
    }

    //TODO : finish this class
}
