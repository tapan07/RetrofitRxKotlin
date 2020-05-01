package com.tapan.retrofitrxkotlin.home.callback

import com.tapan.retrofitrxkotlin.core.base.callback.BaseListener
import com.tapan.retrofitrxkotlin.home.view.HomeView

interface HomeListener<V : HomeView> : BaseListener<V> {

    fun getCellPhoneContent()
}