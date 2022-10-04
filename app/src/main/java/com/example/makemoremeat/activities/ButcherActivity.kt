package com.example.makemoremeat.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.makemoremeat.R
import com.example.makemoremeat.enumerations.EnumProduction
import com.example.makemoremeat.enumerations.EnumRarity
import com.example.makemoremeat.models.Butcher
import com.example.makemoremeat.models.Game

class ButcherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_butcher)

        val game = Game()

        findViewById<Button>(R.id.button).setOnClickListener {
            val production = EnumProduction.values()[(0..12).random()]
            val random = (0..100).random()
            val rarity =
                if (random < 1) EnumRarity.SSR else if (random < 7) EnumRarity.SR else EnumRarity.R
            val butcher = Butcher(rarity, production)
            game.addButcher(butcher)
            val i = Intent(this, GameActivity::class.java)
            startActivity(i)
        }
    }
}