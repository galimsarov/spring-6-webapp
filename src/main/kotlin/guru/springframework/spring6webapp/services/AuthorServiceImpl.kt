package guru.springframework.spring6webapp.services

import guru.springframework.spring6webapp.domain.Author
import guru.springframework.spring6webapp.repositories.AuthorRepository
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {
    override fun findAll(): Iterable<Author> = authorRepository.findAll()
}