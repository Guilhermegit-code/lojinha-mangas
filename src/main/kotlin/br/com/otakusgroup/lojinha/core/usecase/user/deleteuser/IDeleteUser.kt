package br.com.otakusgroup.lojinha.core.usecase.user.deleteuser

import br.com.otakusgroup.lojinha.core.dto.ResponseDto

interface IDeleteUser {
    fun deleteUser(id: Int) : ResponseDto
}