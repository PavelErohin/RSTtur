package com.example.rsttur.screens.main.domain

data class BlogsResponse(
  val data: List<BlogMainScreen>,
  val error: String? = null,
  val success: Boolean = true,
  val time: String = "2022-09-25 01:51:16"
) {
  data class BlogMainScreen(
    val id: Int,
    val image: String,
    val title: String,
    val subtitle: String
  )
}