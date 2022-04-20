package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.core.toDomain
import br.com.otakusgroup.lojinha.core.usecase.createuser.ICreateUser
import br.com.otakusgroup.lojinha.core.usecase.getuser.IGetUsers
import br.com.otakusgroup.lojinha.core.usecase.updateuser.IUpdateUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserControllerImpl(private val createUserPort: ICreateUser,
                         private val updateUserPort: IUpdateUser,
                         private val getUserPort: IGetUsers
) : IUserController {



    @PostMapping("/create")
        override fun insertUser(@RequestBody userDto: UserDto): UserDto {
            return  createUserPort.createUser(userDto.toDomain())
        }

    @PutMapping("{id}")
    override fun updateUserController(@PathVariable id: Int,@RequestBody userDto: UserDto): UserDto {
        return  updateUserPort.updateUser(id, userDto.toDomain())
    }

    @GetMapping
    override fun getUsers(): List<UserDto> {
      return  getUserPort.getUsers()
    }


    override fun getUserById(id: Int): UserDto {
        TODO("Not yet implemented")
    }


}