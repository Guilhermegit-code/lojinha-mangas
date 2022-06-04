package br.com.otakusgroup.lojinha.core.usecase.book

import br.com.otakusgroup.lojinha.core.dto.BookDto

interface IBookByNamePort {
    fun findBookByAuthorName(name: String): List<BookDto>
}