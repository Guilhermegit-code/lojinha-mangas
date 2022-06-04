package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.model.Book

interface IBookDao {
    fun findBookByAuthorId(id: Int): List<Book>
}