package com.springboot.hibernatejpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.hibernatejpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
  // native
  public List<Person> findByProgrammingLanguage(String programmingLanguage);

  // custom
  @Query("SELECT p FROM Person p WHERE p.programmingLanguage = ?1")
  public List<Person> customFindByProgrammingLanguage(String programmingLanguage);

  // native
  public List<Person> findByNameAndProgrammingLanguage(String name, String programmingLanguage);

  // custom
  @Query("SELECT p.name, p.lastname FROM Person p")
  public List<Object> getPersonData();
}
