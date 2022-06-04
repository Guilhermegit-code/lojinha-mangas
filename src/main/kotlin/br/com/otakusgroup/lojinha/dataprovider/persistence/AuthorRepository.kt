package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.dto.AuthorDto
import br.com.otakusgroup.lojinha.core.mapper.AuthorRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class AuthorRepository(private val jdbcTemplate: JdbcTemplate) : IAuthorDao{
    override fun findAuthorByName(name: String): AuthorDto {
        val sql = "select author_id, author_name from public.t_author where author_name = ?"
        return jdbcTemplate.query(sql, AuthorRowMapper(), name).map { author -> AuthorDto(author.id,author.name)}.first()
    }
}