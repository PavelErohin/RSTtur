package com.example.rsttur.screens.main.data

import com.example.rsttur.network.Network
import retrofit2.HttpException

class MainRepository(private val network: Network) {

  private val api = network.retrofit.create(MainService::class.java)

  suspend fun getMain(): MainData? {
    val main = try {
      api.getMain(ID)
    } catch (e: HttpException) {
      return null
    }

    return if (main.success) api.getMain(ID)
    else null
  }

  companion object {
    const val ID = 117
  }
}