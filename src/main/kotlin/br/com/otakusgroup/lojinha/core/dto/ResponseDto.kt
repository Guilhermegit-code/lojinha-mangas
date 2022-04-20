package br.com.otakusgroup.lojinha.core.dto

import org.springframework.http.HttpStatus

data class ResponseDto (
    val message: String,
    val httpStatus: HttpStatus
        )