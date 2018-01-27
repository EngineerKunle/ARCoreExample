package teamkunle.co.uk.arcoresample.app.ui.main

class MainPresenterImpl<in V : MainView> : MainPresenter<V> {

    private var view : V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun setTextForToast() {
    }
}
