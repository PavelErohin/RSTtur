package com.example.rsttur.screens.main.domain

data class MainScreenResponse(
  val buttons: List<Buttons>,
  val content: List<Content>
) {
  data class Content(
    val title: String,
    val isOpenable: Boolean,
    val url: String
  )

  data class Buttons(
    val title: String,
    val url: String
  )
}