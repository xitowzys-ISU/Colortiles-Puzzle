package com.example.canvas.Game

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import kotlin.random.Random


class Game(val gridSize: Int) {

    /**
     * Game grid
     */
    lateinit var gameWindow: GameWindow
    var grid = Array(gridSize) { BooleanArray(gridSize) { false } }
    var tiles: ArrayList<Tile> = ArrayList()

    /**
     * Random generation of the playing field
     */
    private fun generateGrid() {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                grid[i][j] = Random.nextBoolean()
            }
        }

        generateTiles()
//        if (isVictory()) {
//            generateGrid()
//        }
    }

    /**
     * Placing tiles on the field
     */
    private fun generateTiles() {
        val p = Paint()

        for (i in grid.indices) {
            for (j in grid[i].indices) {

                if (grid[i][j]) {
                    p.color = Color.RED
                } else {
                    p.color = Color.BLUE
                }

                tiles.add(
                    Tile(
                        gameWindow.gamePadding + i * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * i,
                        gameWindow.verticalPadding + j * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * j,
                        gameWindow.gamePadding + (i + 1) * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * i,
                        gameWindow.verticalPadding + (j + 1) * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * j,
                        p.color
                    )
                )
            }
        }

        Log.d("tiles: ", tiles.joinToString())
    }

    /**
     * Check if all tiles are compiled
     */
    private fun isVictory(): Boolean {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (!grid[i][j]) {
                    return false
                }
            }
        }

        return true
    }

    /**
     * Bootstrapping the game
     */
    fun startGame(gameWindow: GameWindow) {
        this.gameWindow = gameWindow
        generateGrid()
    }
}