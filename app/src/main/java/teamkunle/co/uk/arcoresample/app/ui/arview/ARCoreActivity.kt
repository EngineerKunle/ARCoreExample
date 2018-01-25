package teamkunle.co.uk.arcoresample.app.ui.arview

import android.os.Bundle
import teamkunle.co.uk.arcoresample.R
import teamkunle.co.uk.arcoresample.app.ui.base.BaseActivity

class ARCoreActivity : BaseActivity(), ARCoreView {

//    lateinit var  customSurfaceView : CustomSurfaceView
    private var presenter = ARCorePresenterImpl<ARCoreView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun initView() {
//        customSurfaceView = CustomSurfaceView(this)
//    custom_surface_view.debugCaller()
    }

    override fun getLayOutResourcedId(): Int {
       return R.layout.activity_arcore
    }
}
