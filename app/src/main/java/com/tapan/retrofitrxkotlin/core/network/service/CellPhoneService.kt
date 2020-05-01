package com.tapan.retrofitrxkotlin.core.network.service

import com.tapan.retrofitrxkotlin.core.network.response.CellPhoneResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Handle the API services
 *
 * @author Tapan Rana (ttapan.rana@gmail.com)
 */
interface CellPhoneService {
    @get:GET("cellphone/db")
    @get:Headers("Content-Type:application/json")
    val cellPhoneContent: Single<CellPhoneResponse>
}