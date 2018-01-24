package teamkunle.co.uk.arcoresample.app.ui.base

import android.support.annotation.LayoutRes

interface BaseView {

    fun initView()

    @LayoutRes
    fun getLayOutResourcedId() : Int
}