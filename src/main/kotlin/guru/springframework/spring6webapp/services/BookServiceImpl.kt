package guru.springframework.spring6webapp.services

import guru.springframework.spring6webapp.domain.Book
import guru.springframework.spring6webapp.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class BookServiceImpl(private val bookRepository: BookRepository) : BookService {
    override fun findAll(): Iterable<Book> = bookRepository.findAll()
}