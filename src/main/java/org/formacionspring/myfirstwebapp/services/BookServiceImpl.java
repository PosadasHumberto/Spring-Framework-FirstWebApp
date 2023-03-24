package org.formacionspring.myfirstwebapp.services;

import org.formacionspring.myfirstwebapp.domain.Book;
import org.formacionspring.myfirstwebapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    //atributos
    private final BookRepository bookRepository;

    //constructor
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //Métodos
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
