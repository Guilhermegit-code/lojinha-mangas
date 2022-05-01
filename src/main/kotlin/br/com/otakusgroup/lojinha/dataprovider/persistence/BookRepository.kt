package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.mapper.BookRowMapper
import br.com.otakusgroup.lojinha.core.model.Book
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class BookRepository(private val jdbcTemplate: JdbcTemplate) : IBookDao {
    override fun findBookByAuthorId(id: Int): List<Book> {
        val sql = "select book_id, book_name, page_count, decription from public.t_book where author_id = ?"
       return jdbcTemplate.query(sql, BookRowMapper(), id)
    }
}