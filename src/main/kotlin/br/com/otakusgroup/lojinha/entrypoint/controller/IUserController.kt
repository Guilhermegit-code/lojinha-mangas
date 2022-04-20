package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.ResponseDto
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface IUserController {
    fun insertUser(userDto: UserDto): UserDto
    fun updateUserController(id: Int,userDto: UserDto): UserDto
    fun getUsers(): List<UserDto>
    fun getUserById(id: Int): UserDto
    fun deleteUser(id: Int) : ResponseDto
}