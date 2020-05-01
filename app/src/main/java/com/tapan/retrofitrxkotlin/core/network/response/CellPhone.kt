package com.tapan.retrofitrxkotlin.core.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CellPhone {
    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("imageUrl")
    @Expose
    var imageUrl: String? = null
}