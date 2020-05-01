package com.tapan.retrofitrxkotlin.core.network.callback

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Create an instance of retrofit for API calls
 *
 * @author Tapan Rana (ttapan.rana@gmail.com)
 */
object RetrofitHandler {

    /**
     * Create an instance of [Retrofit] to make an API calls
     *
     * @param baseUrl API endpoint
     * @return an instance of [Retrofit]
     */
    fun getRetrofitInstance(baseUrl: String): Retrofit {
       return createInstance(baseUrl)
    }

    private fun createInstance(baseUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
}