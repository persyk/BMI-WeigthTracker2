package com.example.bmi_weigthtracker

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams

object HttpUtils {
    private val BASE_URL = "http://5e2dbe3b3b0d640014be0ed3.mockapi.io/api/history"

    private val client = AsyncHttpClient()

    operator fun get(
        url: String,
        params: RequestParams,
        responseHandler: AsyncHttpResponseHandler
    ) {
        client.get(getAbsoluteUrl(url), params, responseHandler)
    }

    fun post(url: String, params: RequestParams, responseHandler: AsyncHttpResponseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler)
    }

    fun getByUrl(url: String, params: RequestParams, responseHandler: AsyncHttpResponseHandler) {
        client.get(url, params, responseHandler)
    }

    fun postByUrl(url: String, params: RequestParams, responseHandler: AsyncHttpResponseHandler) {
        client.post(url, params, responseHandler)
    }

    private fun getAbsoluteUrl(relativeUrl: String): String {
        return BASE_URL + relativeUrl
    }
}