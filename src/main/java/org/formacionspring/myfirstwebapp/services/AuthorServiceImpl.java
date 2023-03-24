package org.formacionspring.myfirstwebapp.services;

import org.formacionspring.myfirstwebapp.domain.Author;
import org.formacionspring.myfirstwebapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    //atributos
    private AuthorRepository authorRepository;

    //constructor

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //métodos
    @Override
    public Iterable<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
