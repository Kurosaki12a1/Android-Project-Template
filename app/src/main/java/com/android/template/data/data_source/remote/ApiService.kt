package com.android.template.data.data_source.remote

import com.android.template.data.model.response.ResponseExample
import retrofit2.http.GET

interface ApiService {
    @GET("data")
    suspend fun getData(): ResponseExample
}