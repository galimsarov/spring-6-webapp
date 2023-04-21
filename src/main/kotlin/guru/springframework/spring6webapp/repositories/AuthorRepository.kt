package guru.springframework.spring6webapp.repositories

import guru.springframework.spring6webapp.domain.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Long>