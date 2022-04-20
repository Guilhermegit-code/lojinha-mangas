package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface IUserDao {
    fun insert(user: User): Int
    fun update(id: Int, user: User) : UserDto
    fun getUsers(): List<UserDto>
}