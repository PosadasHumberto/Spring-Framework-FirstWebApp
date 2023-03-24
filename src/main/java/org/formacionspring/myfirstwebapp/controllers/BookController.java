package org.formacionspring.myfirstwebapp.controllers;

import org.formacionspring.myfirstwebapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    //atributos
    private final BookService bookService;

    //constructor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //métodos
    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
