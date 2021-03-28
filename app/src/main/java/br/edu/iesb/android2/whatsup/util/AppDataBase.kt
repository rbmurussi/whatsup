package br.edu.iesb.android2.whatsup.util

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.iesb.android2.whatsup.domain.LoginData
import br.edu.iesb.android2.whatsup.repository.dao.LoginDataDao

@Database(entities = [LoginData::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getLoginDataDao(): LoginDataDao

}