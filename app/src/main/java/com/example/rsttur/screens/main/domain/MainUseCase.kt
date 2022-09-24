package com.example.rsttur.screens.main.domain

import com.example.rsttur.screens.main.data.MainRepository

class MainUseCase(private val repository: MainRepository) {

  suspend fun getMain(): MainScreenResponse? {
    val main = repository.getMain()
    return if (main != null) {
      return MainScreenResponse(
        buttons = main.data.buttons.map {
          MainScreenResponse.Buttons(
            title = it.title,
            url = it.url
          )
        },
        content = main.data.content.map {
          MainScreenResponse.Content(
            isOpenable = it.template.type == OPENABLE_TYPE,
            title = it.title,
            url = it.url
          )
        }
      )
    } else {
      null
    }
  }

  companion object {
    const val OPENABLE_TYPE = "blog"
  }
}