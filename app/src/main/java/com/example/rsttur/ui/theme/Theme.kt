package com.example.rsttur.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
  primary = Purple80,
  secondary = PurpleGrey80,
  primaryVariant = Pink80
)

private val LightColorPalette = lightColors(
  primary = Color.Blue,
  secondary = Color.Black,
  primaryVariant = Color.Green

  /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MainTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
  val colors = if (darkTheme) {
    LightColorPalette//DarkColorPalette
  } else {
    DarkColorPalette//LightColorPalette
  }

  MaterialTheme(
    colors = colors,
    typography = Typography,
    content = content
  )
}