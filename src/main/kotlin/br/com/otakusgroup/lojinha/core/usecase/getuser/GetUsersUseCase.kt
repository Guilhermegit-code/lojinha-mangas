package br.com.otakusgroup.lojinha.core.usecase.getuser

import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.dataprovider.persistence.IUserDao
import org.springframework.stereotype.Component

@Component
class GetUsersUseCase(private val IUserDao: IUserDao) : IGetUsers {
    override fun getUsers(): List<UserDto> {
       return IUserDao.getUsers()
    }

}