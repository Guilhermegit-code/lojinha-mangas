package br.com.otakusgroup.lojinha.core

import java.time.LocalDateTime

data class User (
    val id: Int?,
    val username: String,
    val password: String,
    val email: String,
    val created_at: LocalDateTime,
    val modified_at: LocalDateTime
        )