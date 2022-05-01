package br.com.otakusgroup.lojinha.core.mapper

import br.com.otakusgroup.lojinha.core.model.Book
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class BookRowMapper : RowMapper<Book>{
    override fun mapRow(rs: ResultSet, rowNum: Int): Book? {
        return Book(
            rs.getInt("book_id"),
            null,
            null,
            rs.getString("book_name"),
            rs.getInt("page_count"),
            rs.getString("decription")
        )
        }
}