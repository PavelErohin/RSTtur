package com.example.rsttur.screens.main.models

import com.example.rsttur.screens.main.views.BlogCardItemModel

sealed class MainViewState {
  object Loading : MainViewState()
  object Error : MainViewState()
  data class Display(
    val items: List<BlogCardItemModel>,
    val title: String
  ) : MainViewState()
}
