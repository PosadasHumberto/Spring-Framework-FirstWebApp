package org.formacionspring.myfirstwebapp.controllers;

import org.formacionspring.myfirstwebapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    //atributos
    private final AuthorService authorService;

    //constructor
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //métodos
    @GetMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
