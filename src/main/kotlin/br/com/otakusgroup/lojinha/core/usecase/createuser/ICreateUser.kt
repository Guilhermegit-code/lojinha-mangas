package br.com.otakusgroup.lojinha.core.usecase.createuser

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface ICreateUser {
    fun createUser(user: User) : UserDto
}