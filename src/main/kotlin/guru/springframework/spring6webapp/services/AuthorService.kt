package guru.springframework.spring6webapp.services

import guru.springframework.spring6webapp.domain.Author

interface AuthorService {
    fun findAll(): Iterable<Author>
}