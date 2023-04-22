package guru.springframework.spring6webapp.controllers

import guru.springframework.spring6webapp.services.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@Suppress("unused")
class BookController(private val bookService: BookService) {
    @RequestMapping("/books")
    fun getBooks(model: Model): String {
        model.addAttribute("books", bookService.findAll())
        return "books"
    }
}