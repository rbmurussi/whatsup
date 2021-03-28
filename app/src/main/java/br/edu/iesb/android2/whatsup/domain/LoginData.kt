package br.edu.iesb.android2.whatsup.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginData(
        @PrimaryKey
        val email: String,
        val pass: String)