package br.edu.iesb.android2.whatsup.util

import android.content.Context
import androidx.room.Room

class DataBaseModule {

    fun createDatabase(applicationContext: Context): AppDataBase {
        return Room
                .databaseBuilder(applicationContext,
                        AppDataBase::class.java,
                        "whatsup_database")
                .build()
    }
}
