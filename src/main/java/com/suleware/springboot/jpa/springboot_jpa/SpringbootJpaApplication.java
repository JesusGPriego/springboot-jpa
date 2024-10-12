package com.suleware.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		findOne();
	}

	private void findOne() {
		personRepository.findOneByname("Jesús").ifPresent(System.out::println);
	}

	private void list() {
		List<Person> persons = personRepository.findByProgrammingLanguageAndName("Java", "Jesús");

		persons.stream().forEach(System.out::println);
	}

}
