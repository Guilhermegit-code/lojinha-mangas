package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.ResponseDto
import br.com.otakusgroup.lojinha.core.dto.UserDto
import br.com.otakusgroup.lojinha.core.mapper.toDomain
import br.com.otakusgroup.lojinha.core.model.User
import br.com.otakusgroup.lojinha.core.mapper.toDomain
import br.com.otakusgroup.lojinha.core.mapper.toDto
import br.com.otakusgroup.lojinha.core.usecase.user.createuser.ICreateUser
import br.com.otakusgroup.lojinha.core.usecase.user.deleteuser.IDeleteUser
import br.com.otakusgroup.lojinha.core.usecase.user.getuser.IGetUsers
import br.com.otakusgroup.lojinha.core.usecase.user.updateuser.IUpdateUser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UseControllerImplTest {

    private  val mockCreateUser = mock(ICreateUser::class.java)


    private  val mockUpdateUser = mock(IUpdateUser::class.java)


    private val mockGetUsers = mock(IGetUsers::class.java)


    private val mockDeleteuser = mock(IDeleteUser::class.java)

    private val userController = UserControllerImpl(mockCreateUser, mockUpdateUser, mockGetUsers, mockDeleteuser )
    private val mockControllerInterface = mock(IUserController::class.java)
    private final val userDto =  UserDto(
      "guizao",
        "123",
        "email@gmail.com"
    )

    private final val user =  User(
        null,
        "guizao",
        "123",
        "email@gmail.com",
        null,
        null
    )


    @Mock
    private  var mockuser: User = mock(User::class.java)
    @Mock
    private  var mockuserDto: UserDto = mock(UserDto::class.java)

    private val mockedList = listOf(userDto, userDto)

    @BeforeEach
    fun setup(){
        MockitoAnnotations.openMocks(this)

//     val userControler = UserControllerImpl(mockCreateUser, mockUpdateUser, mockGetUsers, mockDeleteuser )
    }


    @Test
    fun dadoUsuarioQuandoBuscarEntaoRetornaUsuario(){
        Mockito.`when`(mockGetUsers.getUsers()).thenReturn(mockedList)
       val result = userController.getUsers()
        Assertions.assertEquals(mockedList.first().username, result.first().username)
    }

    @Test
    fun dadoUsuarioQuandoReceberIdEntaoRetornaUsuario(){
        Mockito.`when`(mockGetUsers.getUsersById(anyInt())).thenReturn(userDto)
        val result = userController.getUserById(anyInt())
        Assertions.assertEquals(userDto.username, result.username)
    }

    @Test
    fun dadoUsuarioQuandoDeletarPorIdEntaoRetornaIdDeletado(){
        val fakeResponse = ResponseDto("usuario cadastrado")
        Mockito.`when`(mockDeleteuser.deleteUser(anyInt())).thenReturn(fakeResponse)
        val result = userController.deleteUser(anyInt())
        Assertions.assertEquals("usuario cadastrado", result.message)
    }


    @Test
    fun dadoUsuarioQuandoCriarEntaoRetornaUserDto(){
        Mockito.`when`(mockControllerInterface.insertUser(userDto)).thenReturn(userDto)
        Mockito.`when`(mockCreateUser.createUser(user)).thenReturn(userDto)
        whenever(mockuserDto.toDomain()).thenReturn(user)
        val result = userController.insertUser(userDto)
        Assertions.assertEquals(userDto.username, result.username)
    }


}