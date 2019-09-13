package com.example.nike.model.datasource.remote.retrofit.apiservices

import com.example.nike.model.results.Definition
import com.example.nike.model.results.DefinitionList

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchResultService{


    @Headers(
        "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
        "x-rapidapi-key: 4b224b3a8bmsh016d46687530c34p1774d2jsnacef6eb0b8dc"
    )

    @GET("define")
    fun getDefinitions(@Query("term") word : String): Observable<DefinitionList>
}
