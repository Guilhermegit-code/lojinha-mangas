package br.com.otakusgroup.lojinha.core.mapper

import br.com.otakusgroup.lojinha.core.model.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class UserRowMapper : RowMapper<User> {
    override fun mapRow(rs: ResultSet, rowNum: Int): User {
        return User(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("email"),
            null,
            null
        )

    }
}