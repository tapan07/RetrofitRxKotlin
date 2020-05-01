package com.tapan.retrofitrxkotlin.core.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CellPhoneResponse {

    @SerializedName("cellphone")
    @Expose
    var cellPhones: List<CellPhone> = ArrayList()
}