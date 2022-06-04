package br.com.otakusgroup.lojinha.core.usecase.book

import br.com.otakusgroup.lojinha.core.dto.BookDto
import br.com.otakusgroup.lojinha.core.mapper.toDto
import br.com.otakusgroup.lojinha.dataprovider.persistence.IAuthorDao
import br.com.otakusgroup.lojinha.dataprovider.persistence.IBookDao
import org.springframework.stereotype.Component

@Component
class BookByNameUseCase (private val authorPort: IAuthorDao,
                        private val bookPort: IBookDao) : IBookByNamePort{

    override fun findBookByAuthorName(name: String): List<BookDto> {
         val author = authorPort.findAuthorByName(name)
      return  bookPort.findBookByAuthorId(author.id).map { book -> book.toDto() }
    }

}