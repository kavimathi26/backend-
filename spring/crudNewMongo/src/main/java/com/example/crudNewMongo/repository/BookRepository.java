package com.example.crudNewMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crudNewMongo.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{
}