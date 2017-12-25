package teamkunle.co.uk.arcoresample.app.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

abstract class BaseActivity : AppCompatActivity(){

    companion object {
         const val TAG = "BaseActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val baseView : BaseView = getBaseView()

        if (baseView != null) {
            setContentView(baseView.getLayOutResourcedId())
        } else {
            Log.e(TAG, "Unable to reference Base View")
        }
    }

    protected abstract fun getBaseView() : BaseView
}
