package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.model.User
import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.core.mapper.UserRowMapper
import br.com.otakusgroup.lojinha.core.toDto
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class UserRepository (private val jdbcTemplate: JdbcTemplate) : IUserDao {

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

    override fun getUsers(): List<UserDto> {
        val sql = "select id, username, password, email from public.t_user limit 10"
        val users = jdbcTemplate.query(sql,  UserRowMapper())
        return users.map { user -> UserDto(user.username, user.password, user.email)}
    }

    override fun getUserById(id: Int): UserDto {
        val sql = "select id, username, password, email from public.t_user where id = ?"
        return  jdbcTemplate.query(sql, UserRowMapper(), id).map { user -> UserDto(user.username, user.password, user.email) }.first()
        }

    override fun deleteUser(id: Int): Int {
        val sql = "delete from public.t_user where id = ?"
        return jdbcTemplate.update(sql, id)
    }
}