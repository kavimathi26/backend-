package com.instagram.instaModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@ComponentScan("com.instagram.instaModule.repository")
@SpringBootApplication
public class InstaModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstaModuleApplication.class, args);
	}

}
