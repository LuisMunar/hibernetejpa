package com.springboot.hibernatejpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.hibernatejpa.entities.Person;
import com.springboot.hibernatejpa.repositories.PersonRepository;

@SpringBootApplication
public class HibernatejpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Data persistent using Hibernate JPA.");

		// List<Person> persons = (List<Person>) personRepository.findAll();
		// persons.stream().forEach(person -> System.out.println("PERSON => " + person));

		// List<Person> persons = personRepository.findByProgrammingLanguage("Java");
		// persons.stream().forEach(person -> System.out.println("PERSON => " + person));

		// List<Person> persons = personRepository.customFindByProgrammingLanguage("Javascript");
		// persons.stream().forEach(person -> System.out.println("PERSON => " + person));

		// List<Person> persons = personRepository.findByNameAndProgrammingLanguage("Bob", "JavaScript");
		// persons.stream().forEach(person -> System.out.println("PERSON => " + person));

		// List<Object> persons = personRepository.getPersonData();
		// persons.stream().forEach(person -> System.out.println("PERSON => " + person));

		Optional<Person> person = personRepository.findById((long) 1);
		if (person.isPresent()) {
			System.out.println("PERSON => " + person.get());
		} else {
			System.out.println("PERSON => NOT FOUND");
		}
	}
}
