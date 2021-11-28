package com.example.canvas.Game

class GameWindow(w: Int, h: Int, val gamePadding: Int, val tilesPadding: Int, val gridSize: Int) {

    val smallerSide = if (w < h) w else h
    val biggerSide = if (w > h) w else h
    val tileSize =
        (smallerSide - gamePadding * 2 - tilesPadding * (gridSize - 1)) / gridSize

    val verticalPadding = (biggerSide - tilesPadding * (gridSize - 1) - tileSize * gridSize) / 2
}