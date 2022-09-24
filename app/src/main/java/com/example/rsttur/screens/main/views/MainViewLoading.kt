package com.example.rsttur.screens.main.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.rsttur.ui.theme.RstTheme

@Composable
fun MainViewLoading() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(RstTheme.colors.primaryBackground)
  ) {
    CircularProgressIndicator(
      modifier = Modifier.align(Alignment.Center),
      color = RstTheme.colors.tintColor
    )
  }
}