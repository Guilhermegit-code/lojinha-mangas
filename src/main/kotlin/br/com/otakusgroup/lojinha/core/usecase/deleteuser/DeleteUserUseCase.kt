package br.com.otakusgroup.lojinha.core.usecase.deleteuser

import br.com.otakusgroup.lojinha.core.dto.ResponseDto
import br.com.otakusgroup.lojinha.dataprovider.persistence.IUserDao
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class DeleteUserUseCase (private val userDao: IUserDao): IDeleteUser{
    override fun deleteUser(id: Int): ResponseDto {
        return if (userDao.deleteUser(id) == 0)
            ResponseDto("Usuario nao encontrado na base de dados", HttpStatus.NOT_FOUND)
        else
            ResponseDto(id.toString(), HttpStatus.ACCEPTED)
    }

}