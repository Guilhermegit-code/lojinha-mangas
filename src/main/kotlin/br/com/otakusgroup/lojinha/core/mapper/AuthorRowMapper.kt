package br.com.otakusgroup.lojinha.core.mapper

import br.com.otakusgroup.lojinha.core.model.Author
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class AuthorRowMapper : RowMapper<Author> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Author {
        return Author(
            rs.getInt("author_id"),
            rs.getString("author_name")
        )
    }
}