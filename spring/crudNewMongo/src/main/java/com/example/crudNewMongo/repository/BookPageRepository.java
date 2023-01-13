package com.example.crudNewMongo.repository;

import com.example.crudNewMongo.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface BookPageRepository extends PagingAndSortingRepository<Book, Long>{
}
