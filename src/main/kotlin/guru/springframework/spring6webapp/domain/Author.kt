package guru.springframework.spring6webapp.domain

import jakarta.persistence.*

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    var firstName: String = "",
    var lastName: String = "",

    @ManyToMany(mappedBy = "authors")
    var books: MutableSet<Book> = mutableSetOf()
)