package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.dto.AuthorDto

interface IAuthorDao {
    fun findAuthorByName(name: String): AuthorDto
}