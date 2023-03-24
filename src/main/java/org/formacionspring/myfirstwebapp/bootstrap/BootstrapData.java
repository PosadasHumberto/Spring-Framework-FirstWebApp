package org.formacionspring.myfirstwebapp.bootstrap;

import org.formacionspring.myfirstwebapp.domain.Author;
import org.formacionspring.myfirstwebapp.domain.Book;
import org.formacionspring.myfirstwebapp.domain.Publisher;
import org.formacionspring.myfirstwebapp.repositories.AuthorRepository;
import org.formacionspring.myfirstwebapp.repositories.BookRepository;
import org.formacionspring.myfirstwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
* Esta clase implementa la interfaz CommandLineRunner de Spring.
* CommandLineRunner es una interfaz Spring Boot simple con un método run().
* Spring Boot llamará automáticamente al método de ejecución de todos los
* beans que implementan esta interfaz después de que se haya cargado el
* contexto de la aplicación.
* */

@Component
public class BootstrapData implements CommandLineRunner {

    //atributos
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    //constructor


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override   //Registrar esta clase en el contenedor de beans de Spring
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstname("eric");
        eric.setLastname("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driver Design");
        ddd.setIsbn("123456");


        Author rod = new Author();
        rod.setFirstname("Rod");
        rod.setLastname("Johnson");


        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("5475785");

        Publisher macmillan = new Publisher();
        macmillan.setPublisherName("Macmillan");
        macmillan.setAdress("120 Broadway");
        macmillan.setState("New York");
        macmillan.setCity("New York");
        macmillan.setZip(10271);


        //persistiendo los autores
        Author ericSaved = authorRepository.save(eric);//El método save de CrudRepository persiste al autor y devuelve el mismo autor pero con sus datos una vez persistido. Es decir que el autor se va sin ID, pero regresa con el ID que le asigno la base de datos.
        Author rodSaved = authorRepository.save(rod);

        //persistiendo los libros
        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);

        //persistiendo los Publishers
        Publisher macmillanSaved = publisherRepository.save(macmillan);


        //asociando los autores con los libros
        ericSaved.getBooks().add(dddSaved); //Recupero el Set de libros de ericSaved y le agrego a su set dddSaved.
        rodSaved.getBooks().add(noEJBSaved);//Recupero el Set de libros de rodSaved y le agrego a su set noEJB.

        //asociando los libros con autores
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        //asociando los libros con los publishers
        dddSaved.setPublisher(macmillanSaved);
        noEJBSaved.setPublisher(macmillanSaved);

        //persistiendo las asosiaciones
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);
        publisherRepository.save(macmillanSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());  //el método count() nos permite contar el número de registros que existen en la tabla authors de la base de datos
        System.out.println("Book count: " + bookRepository.count());    //el método count() nos permite contar el número de registros que existen en la tabla books de la base de datos
        System.out.println("Publisher count: " + publisherRepository.count());

    }
}
