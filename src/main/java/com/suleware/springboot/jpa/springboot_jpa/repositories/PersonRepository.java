package com.suleware.springboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.suleware.springboot.jpa.springboot_jpa.dto.PersonDTO;
import com.suleware.springboot.jpa.springboot_jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> programmmingLanguagesDistinct();

    @Query("select new com.suleware.springboot.jpa.springboot_jpa.dto.PersonDTO(p.name, p.lastname) from Person p")
    List<PersonDTO> findAllClassPersonDTO();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllClassPerson();

    @Query("select p.name from Person p where p.id = :id")
    String getPersonNameById(Long id);

    @Query("select p from Person as p where p.id = :id")
    Optional<Person> findOne(Long id);

    @Query("select p from Person as p where p.name = :name")
    Optional<Person> findOneByname(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p from Person as p where p.programmingLanguage = :programmingLanguage")
    List<Person> buscarPorProgrammingLanguage(String programmingLanguage);

}
