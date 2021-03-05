package com.github.repositories.data.apiservice

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.github.repositories.data.model.Result

interface UserService {
    @GET("search/users")
    suspend fun search(@Query("q") query:String): Response<Result>
}