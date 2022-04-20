package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.ResponseDto
import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.core.toDomain
import br.com.otakusgroup.lojinha.core.usecase.createuser.ICreateUser
import br.com.otakusgroup.lojinha.core.usecase.deleteuser.IDeleteUser
import br.com.otakusgroup.lojinha.core.usecase.getuser.IGetUsers
import br.com.otakusgroup.lojinha.core.usecase.updateuser.IUpdateUser
import br.com.otakusgroup.lojinha.entrypoint.controller.validation.validate
import org.springframework.web.bind.annotation.DeleteMapping
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
                         private val getUserPort: IGetUsers,
                         private val deleteUserPort: IDeleteUser
) : IUserController {



    @PostMapping("/create")
        override fun insertUser(@RequestBody userDto: UserDto): UserDto {
          return  verifyAndExecute(userDto)
        }

    @PutMapping("{id}")
    override fun updateUserController(@PathVariable id: Int,@RequestBody userDto: UserDto): UserDto {
        return  updateUserPort.updateUser(id, userDto.toDomain())
    }

    @GetMapping
    override fun getUsers(): List<UserDto> {
      return  getUserPort.getUsers()
    }

    @GetMapping("{id}")
    override fun getUserById(@PathVariable id: Int): UserDto {
      return  getUserPort.getUsersById(id)
    }
    @DeleteMapping("{id}")
    override fun deleteUser(@PathVariable id: Int): ResponseDto {
        return deleteUserPort.deleteUser(id)
    }

    private fun verifyAndExecute( userDto: UserDto): UserDto {
        userDto.validate().let { error ->
           return if (error.isNotEmpty())
                UserDto.withError(error)
            else
                createUserPort.createUser(userDto.toDomain())
        }
    }


}