package com.example.canvas

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

    private fun generateTiles() {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                tiles.add(
                    Tile(
                        gameWindow.gamePadding + i * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * i,
                        gameWindow.verticalPadding + j * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * j,
                        gameWindow.gamePadding + (i + 1) * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * i,
                        gameWindow.verticalPadding + (j + 1) * gameWindow.tileSize.toFloat() + gameWindow.tilesPadding * j
                    )
                )
            }
        }
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

    fun startGame(gameWindow: GameWindow) {
        this.gameWindow = gameWindow
        generateGrid()
    }
}