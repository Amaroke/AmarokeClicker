package com.example.makemoremeat.backups

import android.content.Context
import com.example.makemoremeat.enumerations.FastUP

class GameBackup(context: Context) : BackupToSharedPreference() {

    var money: Double = 0.0
    var fastUP: FastUP = FastUP.X1

    constructor(context: Context, money: Double, fastUP: FastUP) : this(
        context
    ) {
        this.money = money
        this.fastUP = fastUP
    }

    init {
        val savedObject =
            getSavedObjectFromPreference(context, "preferences", "game", GameBackup::class.java)
        this.money = savedObject?.money ?: 0.0
        this.fastUP = savedObject?.fastUP ?: FastUP.X1
        // TODO save butchers and production
    }

}


