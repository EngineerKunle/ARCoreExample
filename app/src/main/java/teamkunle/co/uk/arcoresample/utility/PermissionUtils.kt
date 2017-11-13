package teamkunle.co.uk.arcoresample.utility

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat


class PermissionUtils {

    companion object {
        private val cameraPermission = arrayOf<String>(Manifest.permission.CAMERA)
        private val permissionCode = 0

        @JvmStatic fun requestCameraPermission(activity : Activity) {
            ActivityCompat.requestPermissions(activity, cameraPermission, permissionCode)
        }

        @JvmStatic fun hasCameraPermission(activity: Activity): Boolean  {
            return ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        }
    }
}

