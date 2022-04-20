package br.com.otakusgroup.lojinha.core.usecase.createuser.impl

import br.com.otakusgroup.lojinha.core.User
import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.core.toDto
import br.com.otakusgroup.lojinha.core.usecase.createuser.ICreateUser
import br.com.otakusgroup.lojinha.dataprovider.persistence.IUserDao
import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(private val IUserDao: IUserDao) : ICreateUser {
    override fun createUser(user: User): UserDto {
      val result = verify(user)
      val userReturn =  IUserDao.insert(result)
        if(userReturn == 0){
            throw java.lang.RuntimeException("Erro ao inserir um usuario")
        }
        return result.toDto()
    }

    private fun verify(user: User): User{
        if(user.id == null){
            print("gerando id")
            return user
        }
        return user
    }

}