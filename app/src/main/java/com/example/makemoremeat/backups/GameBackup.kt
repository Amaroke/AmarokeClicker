package com.example.makemoremeat.backups

import android.content.Context
import com.example.makemoremeat.models.Butcher

class GameBackup(context: Context) : BackupToSharedPreference() {

    var money: Double = 0.0
    var fastUP: Int = 1
    var butchers: Array<Butcher> = arrayOf()

    constructor(context: Context, money: Double, fastUP: Int, butchers: Array<Butcher>) : this(
        context
    ) {
        this.money = money
        this.fastUP = fastUP
        this.butchers = butchers
    }

    init {
        val savedObject =
            getSavedObjectFromPreference(context, "preferences", "game", GameBackup::class.java)
        this.money = savedObject?.money ?: 0.0
        this.fastUP = savedObject?.fastUP ?: 1
        this.butchers = savedObject?.butchers ?: arrayOf()
    }

}


