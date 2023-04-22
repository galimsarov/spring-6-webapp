package guru.springframework.spring6webapp.services

import guru.springframework.spring6webapp.domain.Book

interface BookService {
    fun findAll(): Iterable<Book>
}