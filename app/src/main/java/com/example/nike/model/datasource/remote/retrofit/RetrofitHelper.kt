package com.example.nike.model.datasource.remote.retrofit


import com.example.nike.model.datasource.remote.retrofit.apiservices.SearchResultService

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import com.example.nike.model.datasource.remote.retrofit.UrlConstants.BASE_URL


class RetrofitHelper {

    private val retrofitInstance: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val resultService: SearchResultService
        get() = retrofitInstance
            .create(SearchResultService::class.java)
}
