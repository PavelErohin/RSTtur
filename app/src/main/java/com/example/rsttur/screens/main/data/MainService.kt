package com.example.rsttur.screens.main.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

  @GET("main?id=117")
  suspend fun getMain(@Query("id") id: Int): MainData
}