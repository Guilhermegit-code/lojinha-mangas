package br.com.otakusgroup.lojinha.core.usecase.updateuser

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.dataprovider.persistence.IUserDao
import org.springframework.stereotype.Component

@Component
class UpdateUserUseCase(private val IUserDao: IUserDao) : IUpdateUser {
    override fun updateUser(id: Int, user: User): UserDto {
        return IUserDao.update(id, user)
    }
}