package com.example.makemoremeat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.makemoremeat.R

class ButcherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_butcher)
        findViewById<Button>(R.id.button).setOnClickListener{
            val i = Intent(this, GameActivity::class.java)
            startActivity(i)
        }
    }
}