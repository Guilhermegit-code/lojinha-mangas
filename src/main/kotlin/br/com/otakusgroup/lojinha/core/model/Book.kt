package br.com.otakusgroup.lojinha.core.model

data class Book (
    val id: Int,
    val authorId: Int?,
    val categoryId: Int?,
    val bookName: String,
    val pageCount: Int,
    val description: String
        )