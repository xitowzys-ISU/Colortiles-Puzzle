package com.example.canvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.canvas.View.MyView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyView(this))
    }
}