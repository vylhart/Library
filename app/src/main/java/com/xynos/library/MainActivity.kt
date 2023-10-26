package com.xynos.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xynos.pikachu_loader.PikachuLoader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PikachuLoader.show(this)
    }
}