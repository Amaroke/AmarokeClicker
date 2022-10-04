package com.example.makemoremeat.controllers

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.makemoremeat.R
import com.example.makemoremeat.activities.ButcherActivity

class ControllerFooter(context: Activity, viewHeader: View) {

    init {
        val spinner: Button = viewHeader.findViewById(R.id.spinner)
        spinner.setOnClickListener {

            val arrayAdapter: ArrayAdapter<*>
            val users = context.resources.getStringArray(R.array.menuFooter)

            val mListView = viewHeader.findViewById<ListView>(R.id.fdp)
            arrayAdapter = ArrayAdapter(
                context, android.R.layout.simple_list_item_1, users
            )
            if (mListView.adapter == null) {
                mListView.adapter = arrayAdapter
            } else {
                mListView.adapter = null
            }
            mListView.onItemClickListener = OnItemClickListener { _, _, _, _ ->
                val intent = Intent(context, ButcherActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}
