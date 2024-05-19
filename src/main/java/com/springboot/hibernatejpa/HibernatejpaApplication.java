package com.springboot.hibernatejpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernatejpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Data persistent using Hibernate JPA.");
	}
}
