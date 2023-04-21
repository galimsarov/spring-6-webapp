package guru.springframework.spring6webapp.bootstrap

import guru.springframework.spring6webapp.domain.Author
import guru.springframework.spring6webapp.domain.Book
import guru.springframework.spring6webapp.domain.Publisher
import guru.springframework.spring6webapp.repositories.AuthorRepository
import guru.springframework.spring6webapp.repositories.BookRepository
import guru.springframework.spring6webapp.repositories.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
class BootstrapData(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val publisherRepository: PublisherRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val publisher = Publisher(
            publisherName = "ABC Publishing",
            address = "5 Avenue, 42",
            city = "NY",
            state = "NY",
            zipCode = "123000",
        )
        val savedPublisher = publisherRepository.save(publisher)

        val eric = Author(
            firstName = "Eric",
            lastName = "Evans"
        )
        val ddd = Book(
            title = "Domain Driven Design",
            isbn = "123456"
        )
        ddd.publisher = savedPublisher

        val ericSaved = authorRepository.save(eric)
        val dddSaved = bookRepository.save(ddd)

        val rod = Author(
            firstName = "Rod",
            lastName = "Johnson"
        )
        val noEJB = Book(
            title = "J2EE Development without EJB",
            isbn = "547545"
        )
        noEJB.publisher = savedPublisher

        val rodSaved = authorRepository.save(rod)
        val noEJBSaved = bookRepository.save(noEJB)

        ericSaved.books.add(dddSaved)
        rodSaved.books.add(noEJBSaved)
        dddSaved.authors.add(ericSaved)
        noEJBSaved.authors.add(rodSaved)

        bookRepository.save(dddSaved)
        bookRepository.save(noEJBSaved)

        println("In Bootstrap")
        println("Author Count: ${authorRepository.count()}")
        println("Book Count: ${bookRepository.count()}")

        println("Publisher Count: ${publisherRepository.count()}")
    }
}