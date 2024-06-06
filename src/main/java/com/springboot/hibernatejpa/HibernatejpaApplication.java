package com.springboot.hibernatejpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		// createPerson();
		// getPerson();
		// updatePerson();
		// deletePerson();
		getPersonFullNameById();
	}

	@Transactional(readOnly = true)
	public void getPersonFullNameById() {
		String name = personRepository.getPersonFullNameById((long) 1);
		System.out.println("PERSON NAME => " + name);
	}

	@Transactional
	public void createPerson() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter name:");
		String name = scanner.nextLine();

		System.out.println("Enter lastname:");
		String lastname = scanner.nextLine();

		System.out.println("Enter programming language:");
		String programmingLanguage = scanner.nextLine();

		scanner.close();

		Person person = new Person();
		person.setName(name);
		person.setLastname(lastname);
		person.setProgrammingLanguage(programmingLanguage);

		Person result = personRepository.save(person);
		System.out.println("RESULTÍ => " + result);
	}

	@Transactional(readOnly = true)
	public void getPerson() {
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

		// Optional<Person> person = personRepository.findById((long) 1);
		// if (person.isPresent()) {
		// 	System.out.println("PERSON => " + person.get());
		// } else {
		// 	System.out.println("PERSON => NOT FOUND");
		// }

		// Optional<Person> person = personRepository.findOne((long) 1);
		// if (person.isPresent()) {
		// 	System.out.println("PERSON => " + person.get());
		// } else {
		// 	System.out.println("PERSON => NOT FOUND");
		// }

		// Optional<Person> person = personRepository.findOneByName("Bob");
		// if (person.isPresent()) {
		// 	System.out.println("PERSON => " + person.get());
		// } else {
		// 	System.out.println("PERSON => NOT FOUND");
		// }

		// List<Person> person = personRepository.findOneByLikeName("a");
		// System.out.println("PERSON => " + person);

		// Optional<Person> person = personRepository.findByName("Bob");
		// if (person.isPresent()) {
		// 	System.out.println("PERSON => " + person.get());
		// } else {
		// 	System.out.println("PERSON => NOT FOUND");
		// }

		List<Person> person = personRepository.findByNameContaining("a");
		System.out.println("PERSON => " + person);
	}

	@Transactional
	public void updatePerson() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the person id:");
		Long personId = scanner.nextLong();

		Optional<Person> personResult = personRepository.findById(personId);
		if (personResult.isPresent()) {
			System.out.println("Enter the name:");
			String name = scanner.next();
			System.out.println("Enter the lastname:");
			String lastname = scanner.next();

			
			Person p = personResult.get();
			p.setName(name);
			p.setLastname(lastname);
			personRepository.save(p);
		} else {
			System.out.println("PERSON NOT FOUND");
		}

		scanner.close();
	}

	@Transactional
	public void deletePerson() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the person id:");
		Long personId = scanner.nextLong();

		Optional<Person> personResult = personRepository.findById(personId);
		if (personResult.isPresent()) {
			personRepository.delete(personResult.get());
		} else {
			System.out.println("PERSON NOT FOUND");
		}

		scanner.close();
	}
}
