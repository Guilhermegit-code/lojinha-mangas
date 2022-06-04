package br.com.otakusgroup.lojinha.entrypoint.controller

import br.com.otakusgroup.lojinha.core.dto.BookDto
import br.com.otakusgroup.lojinha.core.usecase.book.IBookByNamePort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BooksController(private val bookByNamePort: IBookByNamePort) : IBooksController {

    @GetMapping("getByAuthorName/{authorName}")
    override fun getBooksByAuthorName(@PathVariable authorName: String): List<BookDto> {
      return  bookByNamePort.findBookByAuthorName(authorName)
    }


}