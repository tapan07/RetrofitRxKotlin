package com.tapan.retrofitrxkotlin.core.network.callback

import com.tapan.retrofitrxkotlin.core.network.response.CellPhoneResponse
import com.tapan.retrofitrxkotlin.core.network.service.CellPhoneService
import io.reactivex.Single

/**
 * API handler to fetch the cell phone content
 *
 * @author Tapan Rana (ttapan.rana@gmail.com)
 */
class CellPhoneAPIHandler(private val baseUrl: String) {

    /**
     * Retrieve the content of a web page
     *
     * @return [Single] result of the content
     */
    public fun getCellPhoneContent(): Single<CellPhoneResponse> {
        val cellPhoneService = RetrofitHandler.getRetrofitInstance(baseUrl)
            .create(CellPhoneService::class.java)
        return cellPhoneService.cellPhoneContent
    }

}