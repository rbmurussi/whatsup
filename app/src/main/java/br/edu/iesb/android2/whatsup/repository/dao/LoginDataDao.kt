package br.edu.iesb.android2.whatsup.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.iesb.android2.whatsup.domain.LoginData

@Dao
interface LoginDataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(data: LoginData)

    @Query("select * from LoginData where email = :email")
    suspend fun getLoginData(email: String): LoginData
}