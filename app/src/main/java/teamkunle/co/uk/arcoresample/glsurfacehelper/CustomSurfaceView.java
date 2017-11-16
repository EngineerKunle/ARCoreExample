package teamkunle.co.uk.arcoresample.glsurfacehelper;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class CustomSurfaceView extends GLSurfaceView {

    private final int EGL_CLIENT = 0;
    private GLSurfaceView.Renderer renderer;

    public CustomSurfaceView(Context context, GLSurfaceView.Renderer renderer) {
        super(context);
        this.renderer = renderer;
        initViews();
    }

    private void initViews() {
        setEGLContextClientVersion(EGL_CLIENT);
        setRenderer(renderer);
    }

}
