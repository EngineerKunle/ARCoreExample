package teamkunle.co.uk.arcoresample.rendering

import android.content.Context
import android.opengl.GLES20

class BackgroundRenderer {
    companion object {
        @JvmStatic
        fun loadGlShader(tag : String, context : Context,type : Int ,resId : Int) : Int {

            val code  = readRawTextFile(context, resId)
            var shader = GLES20.glCreateShader(type);

            return shader
        }

        @JvmStatic
        fun readRawTextFile(context: Context, resId : Int) : String {
            return ""
        }
    }

    //TODO : finish this class
}
