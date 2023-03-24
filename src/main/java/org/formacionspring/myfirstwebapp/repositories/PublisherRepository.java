package org.formacionspring.myfirstwebapp.repositories;

import org.formacionspring.myfirstwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
