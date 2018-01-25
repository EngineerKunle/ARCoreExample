package teamkunle.co.uk.arcoresample.app.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView{

    private val TAG = BaseActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayOutResourcedId())
        initView()
    }
}
