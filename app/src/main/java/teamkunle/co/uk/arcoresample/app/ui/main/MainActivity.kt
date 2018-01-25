package teamkunle.co.uk.arcoresample.app.ui.main

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import teamkunle.co.uk.arcoresample.R
import teamkunle.co.uk.arcoresample.app.ui.arview.ARCoreActivity
import teamkunle.co.uk.arcoresample.app.ui.base.BaseActivity

class MainActivity : BaseActivity(), MainView {

    private val TAG = MainActivity::class.simpleName

    private var presenter = MainPresenterImpl<MainView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun initView() {
        launch_button_main.setOnClickListener {
            val intent = Intent(this, ARCoreActivity::class.java)
            startActivity(intent)
        }
    }

    override fun displayToast() {

    }

    override fun getLayOutResourcedId(): Int {
        return R.layout.activity_main
    }
}
