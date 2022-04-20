package br.com.otakusgroup.lojinha.core

import br.com.otakusgroup.lojinha.core.dto.UserDto
import java.time.LocalDateTime
import javax.swing.tree.RowMapper

fun UserDto.toDomain(): User{
    return  User(null, username, password, email, LocalDateTime.now(), LocalDateTime.now())
}

fun User.toDto(): UserDto{
    return  UserDto(username, password, email)
}
