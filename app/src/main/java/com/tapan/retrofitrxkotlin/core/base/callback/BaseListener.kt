package com.tapan.retrofitrxkotlin.core.base.callback

import com.tapan.retrofitrxkotlin.core.base.view.BaseView

interface BaseListener<V : BaseView> {
    fun onAttach(view: V)
    fun onDetach()
    fun handleError(error: Throwable)
}