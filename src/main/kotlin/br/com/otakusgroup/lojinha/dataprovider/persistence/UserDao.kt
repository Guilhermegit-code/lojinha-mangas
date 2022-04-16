package br.com.otakusgroup.lojinha.dataprovider.persistence

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto

interface UserDao {
    fun insert(user: User): Int
    fun update(id: Int, user: User) : UserDto
}