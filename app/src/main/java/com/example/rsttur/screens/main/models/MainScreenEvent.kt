package com.example.rsttur.screens.main.models

sealed class MainScreenEvent {
  object EnterScreen : MainScreenEvent()
  object ReloadScreen : MainScreenEvent()
  data class OnBlogItemClick(val blogId: Long, val newValue: Boolean) : MainScreenEvent()
}

