package br.com.otakusgroup.lojinha.core.usecase.updateuser

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.dataprovider.persistence.UserDao
import org.springframework.stereotype.Component

@Component
class UpdateUserImpl(private val userDao: UserDao) : IUpdateUser {
    override fun updateUser(id: Int, user: User): UserDto {
        return userDao.update(id, user)
    }
}