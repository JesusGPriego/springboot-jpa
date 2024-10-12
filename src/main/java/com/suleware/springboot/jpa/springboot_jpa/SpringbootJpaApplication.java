package com.suleware.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.suleware.springboot.jpa.springboot_jpa.entities.Person;
import com.suleware.springboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	private PersonRepository personRepository;

	public SpringbootJpaApplication(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		create();
	}

	@Transactional
	public void create() {
		Person p = new Person(null, "Lalo", "Thor", "Python");
		Person newPerson = personRepository.save(p);
		System.out.println(newPerson);
	}

	@Transactional(readOnly = true)
	public void findOne() {
		personRepository.findOneByname("Jesús").ifPresent(System.out::println);
	}
	
	@Transactional(readOnly = true)
	public void list() {
		List<Person> persons = personRepository.findByProgrammingLanguageAndName("Java", "Jesús");

		persons.stream().forEach(System.out::println);
	}

}
