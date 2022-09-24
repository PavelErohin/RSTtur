package com.example.rsttur.di

import com.example.rsttur.network.Network
import com.example.rsttur.screens.main.MainViewModel
//import com.example.rsttur.screens.main.MainViewModel
import com.example.rsttur.screens.main.data.MainRepository
import com.example.rsttur.screens.main.domain.MainUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
  //Network
  single { Network() }

  //Main
  single { MainRepository(get()) }
  factory { MainUseCase(get()) }
  viewModel { MainViewModel(get()) }
  //Detail
}