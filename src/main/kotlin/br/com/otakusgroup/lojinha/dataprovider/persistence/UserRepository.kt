package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.core.toDto
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.awt.GraphicsConfigTemplate

@Component
class UserRepository (private val jdbcTemplate: JdbcTemplate) : UserDao {

    override fun insert(user: User): Int {
        val sql = "insert into public.t_user " +
                "(username, password, email, created_at, modified_at) values(?,?,?,?,?)"
       return jdbcTemplate.update(sql, user.username, user.password, user.email, user.created_at, user.modified_at)
    }

    override fun update(id: Int,user: User): UserDto {
        val sql = "update public.t_user set username = ?, password = ?, email = ?, created_at = ?, modified_at = ? where id = ?"
//        val select = "select username, password, email, created_at, modified_at from public.t_user where id = ?"

        val result = jdbcTemplate.update(sql, user.username, user.password, user.email, user.created_at, user.modified_at, id)

        if (result == 0){
            throw java.lang.RuntimeException("id nao encontrado no banco")
        }
        return user.toDto()
    }
}