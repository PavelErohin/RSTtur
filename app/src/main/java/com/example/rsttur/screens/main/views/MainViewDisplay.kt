package com.example.rsttur.screens.main.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rsttur.screens.main.models.MainViewState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainViewDisplay(//modifier: Modifier = Modifier,
                     //navController: NavController,
  viewState: MainViewState.Display,
                     //onCheckedChange: (Long, Boolean) -> Unit
  ) {
  Toolbar()
  Box {
    LazyVerticalGridDemo()
  }
}

@Composable
fun Toolbar() {
  Row(Modifier.padding(16.dp)) {
    Text(
      text = "Главная",
      style = TextStyle(
        color = Color.Black,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
      )
    )
  }
}

@Composable
fun NavButtons() {
  LazyRow(modifier = Modifier.padding(end = 16.dp)) {
    for (i in 1..10)
      item {
        Button(
          onClick = { /*TODO*/ },
          Modifier
            .padding(end = 8.dp)
            .background(
              color = (Color.Blue),
              shape = RoundedCornerShape(8.dp)
            )
            .height(40.dp)
        ) {
          Text(
            "$i  +29",
            style = TextStyle(
              color = Color.White,
              fontWeight = FontWeight.W400,
              fontSize = 14.sp
            )
          )
          Text(
            "°C",
            style = TextStyle(
              color = Color.White,
              fontWeight = FontWeight.W400,
              fontSize = 12.sp
            )
          )
        }
      }
  }
}

@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridDemo() {
  Column(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
    LazyVerticalGrid(
      cells = GridCells.Adaptive(minSize = 160.dp),
      contentPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 16.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      item(span = { GridItemSpan(2) }) { NavButtons() }
      item(span = { GridItemSpan(2) }) {
        Box() {
          Text(
            text = "Домики и номера",
            fontSize = 24.sp,
            fontWeight = FontWeight.W400
          )
        }
      }
      items(20) { item ->
        Box(
          modifier = Modifier
            .padding(4.dp)
            .defaultMinSize(minHeight = 160.dp, minWidth = 160.dp),
          //backgroundColor = Color.White,
        ) {
          Column(
            modifier = Modifier
              .padding(top = 108.dp)
              .width(160.dp)
          ) {
            Box(
              modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
            )
            Text(text = "До 2 гостей", fontSize = 12.sp)
            Text(text = "Guest House (корпус 2)", fontSize = 12.sp)
            Row {
              Text(text = "2 500₽", fontSize = 14.sp)
              Text(modifier = Modifier.padding(start = 4.dp), text = "2 000₽", fontSize = 14.sp)
              Text(text = "/ ночь", fontSize = 12.sp)
            }
          }
        }
      }
    }
  }
}