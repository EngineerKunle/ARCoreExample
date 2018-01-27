package teamkunle.co.uk.arcoresample.utility

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat


class PermissionUtils {

    companion object {
        private val cameraPermission = arrayOf<String>(Manifest.permission.CAMERA)
        private var permissionCode = 0

        @JvmStatic fun requestCameraPermission(activity : Activity) {
            ActivityCompat.requestPermissions(activity, cameraPermission, permissionCode)
        }

        @JvmStatic fun hasCameraPermission(activity: Activity): Boolean  {
            return ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        }

        @JvmStatic fun launchPermissionSettings(activity: Activity) {
            val intent    = Intent()
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            intent.data   = Uri.fromParts("package", activity.packageName, null)
            activity.startActivity(intent)
        }

        @JvmStatic fun shouldShowRequestPermissionRationale(activity: Activity) : Boolean {
            return ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)
        }
    }
}

