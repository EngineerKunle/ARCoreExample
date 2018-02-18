package teamkunle.co.uk.arcoresample.app.ui.arview

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_arcore.*
import teamkunle.co.uk.arcoresample.R
import teamkunle.co.uk.arcoresample.app.ui.base.BaseActivity
import teamkunle.co.uk.arcoresample.utility.PermissionUtils

class ARCoreActivity : BaseActivity(), ARCoreView {

    private var presenter = ARCorePresenterImpl<ARCoreView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        if (PermissionUtils.hasCameraPermission(this)) {
            custom_surface_view.onResume()
        } else {
            PermissionUtils.requestCameraPermission(this)
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (!PermissionUtils.hasCameraPermission(this)) {
            if (!PermissionUtils.shouldShowRequestPermissionRationale(this)) {
                PermissionUtils.launchPermissionSettings(this)
            }
        }
    }

    override fun initView() {
        presenter.attachView(this)
    }

    override fun getLayOutResourcedId(): Int {
       return R.layout.activity_arcore
    }

    override fun permissionCheckCamera() {
        PermissionUtils.requestCameraPermission(this)
    }


}
