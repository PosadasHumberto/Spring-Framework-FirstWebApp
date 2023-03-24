package org.formacionspring.myfirstwebapp.repositories;

import org.formacionspring.myfirstwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
