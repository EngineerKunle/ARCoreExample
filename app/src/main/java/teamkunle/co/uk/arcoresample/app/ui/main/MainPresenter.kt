package teamkunle.co.uk.arcoresample.app.ui.main

import teamkunle.co.uk.arcoresample.app.ui.base.BasePresenter

interface MainPresenter<in V> : BasePresenter<V>{
    fun setTextForToast()
}
