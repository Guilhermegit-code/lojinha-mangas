package br.com.otakusgroup.lojinha.core.usecase.getuser

import br.com.otakusgroup.lojinha.core.dto.UserDto
import org.apache.catalina.User

interface IGetUsers {
    fun getUsers(): List<UserDto>
}
