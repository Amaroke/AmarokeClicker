package com.example.amarokeclicker

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var progressBarStatus = 0
    private var dummy: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get the references from layout file
        val btnStartProgress = this.findViewById<Button>(R.id.button_production1)
        val progressBar = this.findViewById<ProgressBar>(R.id.progressBar_production1)

        // when button is clicked, start the task
        btnStartProgress.setOnClickListener { v ->

            // task is run on a thread
            Thread {
                // dummy thread mimicking some operation whose progress can be tracked
                while (progressBarStatus < 100) {
                    // performing some dummy operation
                    try {
                        dummy += 25
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    // tracking progress
                    progressBarStatus = dummy

                    // Updating the progress bar
                    progressBar.progress = progressBarStatus
                }

            }.start()
        }
    }
}