package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.model.User
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface IUserDao {
    fun insert(user: User): Int
    fun update(id: Int, user: User) : UserDto
    fun getUsers(): List<UserDto>
    fun getUserById(id: Int): UserDto
    fun deleteUser(id: Int): Int
}