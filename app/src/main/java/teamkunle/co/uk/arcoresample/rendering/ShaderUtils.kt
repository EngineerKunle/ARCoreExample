package teamkunle.co.uk.arcoresample.rendering

import android.content.Context
import android.opengl.GLES20
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class ShaderUtils {
    companion object {

        //load shader file
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

        //check if we have an error in Open GL ES
        //TODO : cos you cannot do assignment in kotlin redo this code
        @JvmStatic
        fun checkGLError(tag : String, label : String) {
            var error = GLES20.glGetError()

            if (error != GLES20.GL_NO_ERROR) {
                Log.e(tag, "$label : gl error $error")
                throw RuntimeException("$label : gl error $error")
            }
        }

        //read the raw file
        @JvmStatic
        fun readRawTextFile(context: Context, resId : Int) : String {
            var inputStream : InputStream = context.resources.openRawResource(resId)
            try {
                var reader = BufferedReader(InputStreamReader(inputStream))
                var sb    = StringBuilder()
                var line : String? = null

                while({ line = reader.readLine(); line }() != null) {
                    sb.append(line).append("\n")
                }

                reader.close()
                return sb.toString()

            } catch (e : IOException) {
                e.printStackTrace()
            }
            return "ran into error"
        }
    }

    //TODO : finish this class
}
