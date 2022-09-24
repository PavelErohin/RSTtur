package com.example.rsttur.screens.main.data

import com.google.gson.annotations.SerializedName

data class MainData(
  val success: Boolean,
  val error: String?,
  val time: String,
  val data: Data
) {

  data class Data(
    val buttons: List<Buttons>,
    val content: List<Content>
  ) {

    data class Content(
      val title: String,
      val template: Template,
      val url: String
    ) {
      data class Template(
        val card: String,
        @SerializedName("object") val type: String,
        val size: String,
        val direction: String
      )
    }

    data class Buttons(
      val icon: String,
      val color: String,
      val title: String,
      val type: String,
      val url: String
    )
  }
}
