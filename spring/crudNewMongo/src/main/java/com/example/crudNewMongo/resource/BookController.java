package com.example.crudNewMongo.resource;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crudNewMongo.model.Book;
import com.example.crudNewMongo.repository.BookRepository;
import com.example.crudNewMongo.service.BookService;
import org.springframework.data.domain.Page;
@RestController
public class BookController {
@Autowired
    private BookRepository repository;
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) { //create
        bookService.saveBook(book);
        return "Added book with id : " + book.getId();
    }

    @GetMapping
    public Page<Book> getBooks() { //list-all
        return (Page<Book>) bookService.getBooks(1);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable int id) { //get-one
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) { //delete
        return bookService.deleteBook(id);
//        return "book deleted with id : " + id;
    }

}