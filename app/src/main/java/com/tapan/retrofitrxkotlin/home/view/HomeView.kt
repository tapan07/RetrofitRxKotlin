package com.tapan.retrofitrxkotlin.home.view

import com.tapan.retrofitrxkotlin.core.base.view.BaseView
import com.tapan.retrofitrxkotlin.core.network.response.CellPhone

interface HomeView : BaseView {
    fun updateCellPhoneContent(cellPhones: List<CellPhone>)
    fun noDataAvailable()
}