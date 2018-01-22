package teamkunle.co.uk.arcoresample.app.ui.base


interface BasePresenter<in V> {

    fun attachView(view : V)
    fun detachView()
}