package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.UserDto

interface UserController {
    fun insertUser(userDto: UserDto): UserDto
    fun updateUserController(id: Int,userDto: UserDto): UserDto
}