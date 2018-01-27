package teamkunle.co.uk.arcoresample.app.ui.base


interface BasePresenter<in V : BaseView> {

    fun attachView(view : V)
    fun detachView()
}