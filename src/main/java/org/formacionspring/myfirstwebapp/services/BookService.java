package org.formacionspring.myfirstwebapp.services;

import org.formacionspring.myfirstwebapp.domain.Book;

public interface BookService {

    //firmas de métodos
    Iterable<Book> findAll();
}
