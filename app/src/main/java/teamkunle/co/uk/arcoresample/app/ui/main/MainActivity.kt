package teamkunle.co.uk.arcoresample.app.ui.main

import android.os.Bundle
import android.util.Log
import teamkunle.co.uk.arcoresample.app.ui.base.BaseActivity
import teamkunle.co.uk.arcoresample.app.ui.base.BaseView

class MainActivity : BaseActivity(), MainView {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "On create called")
    }

    override fun getBaseView(): BaseView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initview() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayToast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayOutResourcedId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
