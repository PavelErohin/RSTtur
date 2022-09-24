package com.example.rsttur.screens.main.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rsttur.screens.main.domain.BlogsResponse
import com.example.rsttur.ui.theme.RstTheme

data class BlogCardItemModel(
  val blogId: Int,
  val image: String,
  val title: String,
  val subtitle: String
)

fun BlogsResponse.BlogMainScreen.mapToCardItem() =
  BlogCardItemModel(
    blogId = this.id,
    image = this.image,
    title = this.title,
    subtitle = this.subtitle
  )

@Composable
fun BlogCardItem(
  model: BlogCardItemModel,
) {
  Card(
    modifier = Modifier
      .fillMaxWidth(),
    backgroundColor = RstTheme.colors.primaryBackground,
    shape = RstTheme.shapes.cornersStyle
  ) {
    Row(
      modifier = Modifier
        .padding(RstTheme.shapes.padding)
        .fillMaxWidth()
    ) {
      Text(
        text = model.title,
        style = RstTheme.typography.body,
        color = RstTheme.colors.primaryText
      )
    }
  }
}

