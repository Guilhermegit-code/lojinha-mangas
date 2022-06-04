package br.com.otakusgroup.lojinha.core.dto

data class UserDto (

    val username: String,
    val password: String,
    val email: String,
    val error: Set<String>?
    )
{
    companion object {
        fun withError(error: Set<String>): UserDto{
            return UserDto(
                "",
                "",
                "",
                error

            )
        }


    }
}

