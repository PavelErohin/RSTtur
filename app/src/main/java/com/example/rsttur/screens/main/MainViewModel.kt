package com.example.rsttur.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rsttur.base.EventHandler
import com.example.rsttur.screens.main.domain.BlogsResponse
import com.example.rsttur.screens.main.domain.MainUseCase
import com.example.rsttur.screens.main.models.MainScreenEvent
import com.example.rsttur.screens.main.models.MainViewState
import com.example.rsttur.screens.main.views.BlogCardItemModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(
  private val useCase: MainUseCase
) : ViewModel(), EventHandler<MainScreenEvent> {

  private val _mainViewState: MutableLiveData<MainViewState> =
    MutableLiveData(MainViewState.Loading)
  val mainViewState: LiveData<MainViewState> = _mainViewState

  override fun obtainEvent(event: MainScreenEvent) {
    when (val currentState = _mainViewState.value) {
      is MainViewState.Loading -> reduce(event, currentState)
      is MainViewState.Display -> reduce(event, currentState)
      is MainViewState.Error -> reduce(event, currentState)
    }
  }

  private fun reduce(event: MainScreenEvent, currentState: MainViewState.Loading) {
    when (event) {
      MainScreenEvent.EnterScreen -> fetchHabbitForDate()
    }
  }

  private fun reduce(event: MainScreenEvent, currentState: MainViewState.Display) {
    when (event) {
      MainScreenEvent.EnterScreen -> fetchHabbitForDate()
      is MainScreenEvent.OnBlogItemClick -> performHabbitClick(
        habbitId = event.habitId
      )
    }
  }

  private fun reduce(event: MainScreenEvent, currentState: MainViewState.Error) {
    when (event) {
      MainScreenEvent.ReloadScreen -> fetchHabbitForDate(needsToRefresh = true)
    }
  }

  private fun performHabbitClick(habbitId: Long) {
    viewModelScope.launch {
      val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
      goBlog(
        habbitId = habbitId
      )
    }
  }

  private fun goBlog(habbitId: Long) {

  }

  private fun fetchHabbitForDate(needsToRefresh: Boolean = false, setHasNextDay: Boolean = false) {
    if (needsToRefresh) {
      _mainViewState.postValue(MainViewState.Loading)
    }

    viewModelScope.launch {
      try {
        val habbits = useCase.getMain()
        val blogsResponse = listOf(
          BlogsResponse.BlogMainScreen(
            233,
            "https://cdn2.rsttur.ru/photos/blog-233-700-400-80.webp?v=1663567527",
            "Чем заняться в Приморье осенью",
            "Отдых в Приморье осенью. Погода в осенние месяцы, виды развлчений, туры и базы отдыха."
          ),
          BlogsResponse.BlogMainScreen(
            233,
            "https://cdn2.rsttur.ru/photos/blog-233-700-400-80.webp?v=1663567527",
            "Чем заняться в Приморье осенью",
            "Отдых в Приморье осенью. Погода в осенние месяцы, виды развлчений, туры и базы отдыха."
          )
        )

        val cardItems: List<BlogCardItemModel> = blogsResponse.map { blog ->
          BlogCardItemModel(
            blogId = blog.id,
            title = blog.title,
            subtitle = blog.subtitle,
            image = blog.image
          )
        }


        _mainViewState.postValue(
          MainViewState.Display(
            items = cardItems,
            title = "Блог",

          )
        )

      } catch (e: Exception) {
        _mainViewState.postValue(MainViewState.Error)
      }
    }
  }
}
/*
class MainViewModel(private val useCase: MainUseCase): ViewModel() {

  val mainFlow = MutableStateFlow<MainDomain?>(null)

  init {
    viewModelScope.launch {
      mainFlow.value = useCase.getMain()
    }
  }
}*/
