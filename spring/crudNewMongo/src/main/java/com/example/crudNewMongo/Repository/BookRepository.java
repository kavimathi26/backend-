package com.example.crudNewMongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crudNewMongo.Model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}