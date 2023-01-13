package com.example.crudNewMongo.service;

import com.example.crudNewMongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crudNewMongo.model.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
@Service
public class BookService {
    @Autowired
    private BookRepository repository;
    public Book saveBook(Book book) {
        return repository.save(book);
    }

        public Page<Book> getBooks(int pageNo) {
            Pageable pageableBase = PageRequest.of(pageNo, 5);
            return (Page<Book>) repository.findAll(pageableBase);
        }

    public String deleteBook(int id) {
        repository.deleteById(id);
        return "book deleted with id : " + id;
    }

    public Page<Book> findAll(int pageNo) {
        Pageable pageableBase = PageRequest.of(pageNo, 5);
        return repository.findAll(pageableBase);
    }

    public Optional<Book> getBook(int id) {
        return repository.findById(id);
    }


}
