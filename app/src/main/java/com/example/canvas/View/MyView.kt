package com.example.canvas.View

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.canvas.Game.Game
import com.example.canvas.Game.GameWindow
import com.example.canvas.R

class MyView(context: Context?) : View(context) {
    private val p = Paint()

    private val gridSize = 3
    private val game = Game(gridSize)

    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        val gameWindow = GameWindow(right, bottom, 100, 40, gridSize)
        game.startGame(gameWindow)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {
            drawColor(Color.YELLOW)

            for (tile in game.tiles) {
                p.color = tile.color
                drawRect(tile.x, tile.y, tile.width, tile.height, p)
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        game.clickTiles(event?.x ?: 0f, event?.y ?: 0f)

        invalidate()

        if (game.isVictory()) {
            val toast = Toast.makeText(context, context.getString(R.string.win_text), Toast.LENGTH_LONG)
            toast.show()
        }

        return false
    }


}