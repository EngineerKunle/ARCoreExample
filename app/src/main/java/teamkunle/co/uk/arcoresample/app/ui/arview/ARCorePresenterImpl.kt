package teamkunle.co.uk.arcoresample.app.ui.arview


class ARCorePresenterImpl<in V : ARCoreView> : ARCorePresenter<V> {

    private var arCoreView : V? = null

    override fun attachView(view: V) {
        this.arCoreView = view
    }

    override fun detachView() {
        arCoreView = null
    }

}