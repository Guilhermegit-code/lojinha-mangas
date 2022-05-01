package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.BookDto
import br.com.otakusgroup.lojinha.core.model.Book

interface IBooksController {
    fun getBooksByAuthorName(authorName: String): List<BookDto>
}