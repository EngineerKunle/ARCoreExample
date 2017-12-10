package teamkunle.co.uk.arcoresample.rendering


class PointCloudRenderer {

    companion object {
        private const val TAG = "PointCloudRenderer"
        private const val BYTES_PER_FLOAT       = 32 / 8
        private const val FLOATS_PER_POINT      = 4
        private const val BYTES_PER_POINT       = BYTES_PER_FLOAT * FLOATS_PER_POINT
        private const val INITIAL_BUFFER_POINTS = 1000;
    }
}