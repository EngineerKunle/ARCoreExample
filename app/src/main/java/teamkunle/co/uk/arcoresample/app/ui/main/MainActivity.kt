package teamkunle.co.uk.arcoresample.app.ui.main

import android.os.Bundle
import android.util.Log
import teamkunle.co.uk.arcoresample.app.ui.base.BaseActivity

class MainActivity : BaseActivity(), MainView {

    private val TAG = MainActivity::class.simpleName

    private var presenter = MainPresenterImpl<MainView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        Log.d(TAG, "On create called")
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun initview() {

    }

    override fun displayToast() {

    }

    override fun getLayOutResourcedId(): Int {
        return -1
    }
}
