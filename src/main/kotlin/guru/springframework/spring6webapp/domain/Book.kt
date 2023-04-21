package guru.springframework.spring6webapp.domain

import jakarta.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    var title: String = "",
    var isbn: String = "",

    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    var authors: MutableSet<Author> = mutableSetOf(),

    @ManyToOne
    var publisher: Publisher = Publisher()
)