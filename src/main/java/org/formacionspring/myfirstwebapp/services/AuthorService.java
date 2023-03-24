package org.formacionspring.myfirstwebapp.services;

import org.formacionspring.myfirstwebapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
