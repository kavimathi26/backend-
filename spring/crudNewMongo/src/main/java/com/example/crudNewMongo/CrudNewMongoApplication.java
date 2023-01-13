package com.example.crudNewMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.example.CrudNewMongo.Resource.BookController")
@SpringBootApplication
public class CrudNewMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudNewMongoApplication.class, args);
	}
}