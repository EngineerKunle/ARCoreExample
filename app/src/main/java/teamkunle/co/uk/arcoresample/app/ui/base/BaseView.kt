package teamkunle.co.uk.arcoresample.app.ui.base

import android.support.annotation.LayoutRes

interface BaseView {

    fun initview()

    @LayoutRes
    fun getLayOutResourcedId() : Int
}