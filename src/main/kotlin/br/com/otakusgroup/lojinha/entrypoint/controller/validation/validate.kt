package br.com.otakusgroup.lojinha.entrypoint.controller.validation

import br.com.otakusgroup.lojinha.core.dto.UserDto

fun UserDto.validate(): Set<String>{
    return HashSet<String>().apply {
        if(username.isBlank()){
            add("nome nao pode ser nulo")
        }
    }
}
