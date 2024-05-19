package com.springboot.hibernatejpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.hibernatejpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
