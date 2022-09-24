package com.example.rsttur.base

interface EventHandler<T> {
  fun obtainEvent(event: T)
}