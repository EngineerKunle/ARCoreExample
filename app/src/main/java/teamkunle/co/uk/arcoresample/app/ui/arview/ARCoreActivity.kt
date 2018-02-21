package teamkunle.co.uk.arcoresample.app.ui.arview

import android.os.Bundle
import android.util.Log
import com.google.ar.core.Session
import com.google.ar.core.exceptions.UnavailableApkTooOldException
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException
import com.google.ar.core.exceptions.UnavailableSdkTooOldException
import kotlinx.android.synthetic.main.activity_arcore.*
import teamkunle.co.uk.arcoresample.R
import teamkunle.co.uk.arcoresample.app.ui.base.BaseActivity
import teamkunle.co.uk.arcoresample.utility.PermissionUtils

class ARCoreActivity : BaseActivity(), ARCoreView {

    private var presenter = ARCorePresenterImpl<ARCoreView>()
    private lateinit var session : Session
    private val TAG = ARCoreActivity::class.simpleName

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

        //start session
        var exception : Exception? = null
        var message : String? = null

        try {
            session = Session(this)
        } catch (e : UnavailableArcoreNotInstalledException) {
            message   = "Please install AR"
            exception = e
        } catch (e : UnavailableApkTooOldException) {
            message   = "Please update ARCore"
            exception = e
        } catch (e : UnavailableSdkTooOldException) {
            message   = "Please update this app"
            exception = e
        } catch (e : Exception) {
            message   = "This device does not support AR"
        }

        //TODO : show snackbar method
        message.let {
            Log.e(TAG, "Exception creating session  " + exception)
            return
        }
    }

    override fun getLayOutResourcedId(): Int {
       return R.layout.activity_arcore
    }

    override fun permissionCheckCamera() {
        PermissionUtils.requestCameraPermission(this)
    }


}
