package br.com.otakusgroup.lojinha.core.usecase.updateuser

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface IUpdateUser {
    fun updateUser(id: Int,user: User): UserDto
}