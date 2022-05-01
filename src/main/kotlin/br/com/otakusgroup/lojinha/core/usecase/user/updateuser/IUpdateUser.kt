package br.com.otakusgroup.lojinha.core.usecase.user.updateuser

import br.com.otakusgroup.lojinha.core.model.User
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface IUpdateUser {
    fun updateUser(id: Int,user: User): UserDto
}