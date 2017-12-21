package teamkunle.co.uk.arcoresample.rendering

import com.google.ar.core.Anchor
import com.google.ar.core.Plane
import com.google.ar.core.Pose

class PlaneAttachment(private val plane : Plane, val anchor: Anchor) {
    private val poseTranslation = FloatArray(3)
    private val poseRotation = FloatArray(4)

    val isTracking : Boolean
        get() = plane.trackingState == Plane.TrackingState.TRACKING && anchor.trackingState == Anchor.TrackingState.TRACKING

    val pose : Pose
        get() {
            val pose = anchor.pose
            pose.getTranslation(poseTranslation, 0)
            pose.getRotationQuaternion(poseRotation, 0)
            poseTranslation[1] = plane.centerPose.ty()
            return Pose(poseTranslation, poseRotation)
        }
}
