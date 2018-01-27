package teamkunle.co.uk.arcoresample.app.ui.arview

import android.os.Bundle
import teamkunle.co.uk.arcoresample.R
import teamkunle.co.uk.arcoresample.app.ui.base.BaseActivity
import teamkunle.co.uk.arcoresample.utility.PermissionUtils

class ARCoreActivity : BaseActivity(), ARCoreView {

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
    }

    override fun getLayOutResourcedId(): Int {
       return R.layout.activity_arcore
    }

    override fun permissionCheckCamera() {
        PermissionUtils.requestCameraPermission(this)
    }
}
