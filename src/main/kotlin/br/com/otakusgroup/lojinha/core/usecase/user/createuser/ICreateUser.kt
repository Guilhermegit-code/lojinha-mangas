package br.com.otakusgroup.lojinha.core.usecase.user.createuser

import br.com.otakusgroup.lojinha.core.model.User
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface ICreateUser {
    fun createUser(user: User) : UserDto
}