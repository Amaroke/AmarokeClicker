package com.example.makemoremeat.activities

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.makemoremeat.R

class ButcherActivity : AppCompatActivity() {

    // TODO Idée de Lore : * Chicken Butcher : Wings/Nuggets/Tenders Master
    // * Vegans Butcher : Cannibal Lecter
    // TODO GACHA 10 levels (3* empty/bronze/silver/gold)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION") window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        setContentView(R.layout.activity_butcher)
    }
}