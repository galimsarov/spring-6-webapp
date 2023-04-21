package guru.springframework.spring6webapp.domain

import jakarta.persistence.*

@Entity
data class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    var publisherName: String = "",
    var address: String = "",
    var city: String = "",
    var state: String = "",
    var zipCode: String = "",

    @OneToMany(mappedBy = "publisher")
    var books: MutableSet<Book> = mutableSetOf()
)
