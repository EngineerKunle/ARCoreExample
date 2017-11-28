package teamkunle.co.uk.arcoresample.rendering

import android.content.Context

class BackgroundRenderer {
    companion object {
        @JvmStatic
        fun loadGlShader(tag : String, context : Context,type : Int ,resId : Int) : Int {

            val code  = readRawTextFile(context, resId)


            return 1
        }

        @JvmStatic
        fun readRawTextFile(context: Context, resId : Int) : String {
            return ""
        }
    }
}
