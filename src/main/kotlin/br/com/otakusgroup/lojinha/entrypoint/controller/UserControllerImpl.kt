package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.core.toDomain
import br.com.otakusgroup.lojinha.core.usecase.createuser.CreateUser
import br.com.otakusgroup.lojinha.core.usecase.updateuser.IUpdateUser
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserControllerImpl(private val createUser: CreateUser, private val updateUser: IUpdateUser) : UserController {

    @PostMapping("/create")
        override fun insertUser(@RequestBody userDto: UserDto): UserDto {
            return  createUser.createUser(userDto.toDomain())
        }

    @PutMapping("{id}")
    override fun updateUserController(@PathVariable id: Int,@RequestBody userDto: UserDto): UserDto {
        return  updateUser.updateUser(id, userDto.toDomain())
    }




}