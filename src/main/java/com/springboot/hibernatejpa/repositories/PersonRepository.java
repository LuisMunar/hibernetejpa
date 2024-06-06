package com.springboot.hibernatejpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.hibernatejpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
  // custom
  @Query("SELECT p FROM Person p WHERE p.id = ?1")
  Optional<Person> findOne(Long id);

  // custom
  @Query("SELECT p FROM Person p WHERE p.name = :name")
  Optional<Person> findOneByName(String name);

  // native
  Optional<Person> findByName(String name);

  // custom
  @Query("SELECT p FROM Person p WHERE p.name LIKE %:name%")
  List<Person> findOneByLikeName(String name);

  // native
  List<Person> findByNameContaining(String name);

  // native
  List<Person> findByProgrammingLanguage(String programmingLanguage);

  // custom
  @Query("SELECT p FROM Person p WHERE p.programmingLanguage = ?1")
  List<Person> customFindByProgrammingLanguage(String programmingLanguage);

  // native
  List<Person> findByNameAndProgrammingLanguage(String name, String programmingLanguage);

  // custom
  @Query("SELECT p.name, p.lastname FROM Person p")
  List<Object> getPersonData();

  // custom
  @Query("SELECT CONCAT(p.name, ' ', p.lastname) FROM Person p WHERE p.id = :id")
  String getPersonFullNameById(Long id);
}
