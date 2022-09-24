package com.example.rsttur.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class RstColors(
  val primaryText: Color,
  val primaryBackground: Color,
  val secondaryText: Color,
  val secondaryBackground: Color,
  val tintColor: Color,
  val controlColor: Color,
  val errorColor: Color
)

data class RstTypography(
  val heading: TextStyle,
  val body: TextStyle,
  val toolbar: TextStyle,
  val caption: TextStyle
)

data class RstShape(
  val padding: Dp,
  val cornersStyle: Shape
)

data class RstImage(
  val mainIcon: Int,
  val mainIconDescription: String
)

object RstTheme {
  val colors: RstColors
    @Composable
    get() = LocalRstColors.current

  val typography: RstTypography
    @Composable
    get() = LocalRstTypography.current

  val shapes: RstShape
    @Composable
    get() = LocalRstShape.current

  val images: RstImage
    @Composable
    get() = LocalRstImage.current
}


val LocalRstColors = staticCompositionLocalOf<RstColors> {
  error("No colors provided")
}

val LocalRstTypography = staticCompositionLocalOf<RstTypography> {
  error("No font provided")
}

val LocalRstShape = staticCompositionLocalOf<RstShape> {
  error("No shapes provided")
}

val LocalRstImage = staticCompositionLocalOf<RstImage> {
  error("No images provided")
}