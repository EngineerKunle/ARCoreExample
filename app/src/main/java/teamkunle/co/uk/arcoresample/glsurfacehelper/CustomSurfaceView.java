package teamkunle.co.uk.arcoresample.glsurfacehelper;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class CustomSurfaceView extends GLSurfaceView {

    private final int EGL_CLIENT = 0;

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    private void initViews() {
        setEGLContextClientVersion(EGL_CLIENT);
        CustomRenderer renderer = new CustomRenderer();
        setEGLContextClientVersion(2);
        setRenderer(renderer);
    }

    public void debugCaller() {
        System.out.println("it has been called");
    }

}
