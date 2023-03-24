package org.formacionspring.myfirstwebapp.repositories;

import org.formacionspring.myfirstwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
