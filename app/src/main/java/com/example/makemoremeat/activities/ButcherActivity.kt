package com.example.makemoremeat.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.makemoremeat.R
import com.example.makemoremeat.enumerations.ProductionInformation
import com.example.makemoremeat.enumerations.Rarity
import com.example.makemoremeat.models.Butcher
import com.example.makemoremeat.models.Game
import com.example.makemoremeat.tools.DbConstants

class ButcherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_butcher)

        val game = Game()

        findViewById<Button>(R.id.button).setOnClickListener {
            val production = ProductionInformation.values()[(0 until DbConstants.PRODUCTION_NUMBER).random()]
            val random = (0..100).random()
            val rarity =
                if (random < 1) Rarity.SSR else if (random < 7) Rarity.SR else Rarity.R
            val butcher = Butcher(rarity, production)
            game.addButcher(butcher)
            val i = Intent(this, GameActivity::class.java)
            startActivity(i)
        }
    }
}