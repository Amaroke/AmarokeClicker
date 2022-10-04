package com.example.makemoremeat.backups

import android.content.Context

class GameBackup(context: Context) : BackupToSharedPreference() {

    var money: Double = 0.0
    var fastUP: Int = 1

    constructor(context: Context, money: Double, fastUP: Int) : this(
        context
    ) {
        this.money = money
        this.fastUP = fastUP
    }

    init {
        val savedObject =
            getSavedObjectFromPreference(context, "preferences", "game", GameBackup::class.java)
        this.money = savedObject?.money ?: 0.0
        this.fastUP = savedObject?.fastUP ?: 1
        // TODO save butchers and production
    }

}


