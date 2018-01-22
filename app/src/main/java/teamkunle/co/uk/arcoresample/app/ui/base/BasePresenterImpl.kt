package teamkunle.co.uk.arcoresample.app.ui.base

open class BasePresenterImpl < V : BaseView > : BasePresenter<V>{

    var view  : V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}
