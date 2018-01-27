package teamkunle.co.uk.arcoresample.glsurfacehelper;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class CustomSurfaceView extends GLSurfaceView  {

    private final int EGL_CLIENT = 0;
    private final String TAG = CustomSurfaceView.class.getSimpleName();

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    private void initViews() {
        setEGLContextClientVersion(EGL_CLIENT);
        CustomRenderer renderer = new CustomRenderer();
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "Custom view was touched");
        return super.onTouchEvent(event);
    }
}
