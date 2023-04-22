package guru.springframework.spring6webapp.controllers

import guru.springframework.spring6webapp.services.AuthorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@Suppress("unused")
class AuthorController(private val authorService: AuthorService) {
    @RequestMapping("/authors")
    fun getAuthors(model: Model): String {
        model.addAttribute("authors", authorService.findAll())
        return "authors"
    }
}