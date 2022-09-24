package com.example.rsttur.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rsttur.screens.main.models.MainScreenEvent
import com.example.rsttur.screens.main.models.MainViewState
import com.example.rsttur.screens.main.views.MainViewDisplay
import com.example.rsttur.screens.main.views.MainViewError
import com.example.rsttur.screens.main.views.MainViewLoading

@ExperimentalFoundationApi
@Composable
fun MainScreen(
  //modifier: Modifier = Modifier,
  //navController: NavController,
  //val vm = getViewModel<MyViewModel>()
) {
  val vm = getViewModel<MainViewModel>()
  val mainViewModel by viewModel<MainViewModel>()
  val viewState = mainViewModel.mainViewState.observeAsState()

  when (val state = viewState.value) {
    MainViewState.Loading -> MainViewLoading()
    MainViewState.Error -> MainViewError {
      mainViewModel.obtainEvent(MainScreenEvent.ReloadScreen)
    }
    is MainViewState.Display -> MainViewDisplay(
      viewState = state
    )
    else -> throw NotImplementedError("Unexpected main state")
  }

  LaunchedEffect(key1 = viewState, block = {
    mainViewModel.obtainEvent(event = MainScreenEvent.EnterScreen)
  })
}