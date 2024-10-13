package com.suleware.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
		programmmingLanguagesDistinct();
	}

	@Transactional(readOnly = true)
	public void programmmingLanguagesDistinct() {
		personRepository.programmmingLanguagesDistinct().forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void classInstQuery() {
		personRepository.findAllClassPerson().forEach(System.out::println);
		personRepository.findAllClassPersonDTO().forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void customQueries() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert person ID");
		Long id = scanner.nextLong();
		String pName = personRepository.getPersonNameById(id);
		System.out.println(String.format("Person with id %s is %s", id, pName));
	}

	@Transactional
	public void create() {
		Person p = new Person(null, "Lalo", "Thor", "Python");
		Person newPerson = personRepository.save(p);
		System.out.println(newPerson);
	}

	@Transactional
	public void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert person ID");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresent(person -> {
			System.out.println(person);
			System.out.println(String.format("Insert new programming lenguage for perosn with ID %s", person.getId()));
			String programmingLanguage = scanner.next();

			person.setProgrammingLanguage(programmingLanguage);
			Person personDB = personRepository.save(person);
			System.out.println(personDB);
		});
		scanner.close();
	}

	@Transactional
	public void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert person ID");

		Long id = scanner.nextLong();

		Optional<Person> oPerson = personRepository.findById(id);

		oPerson.ifPresentOrElse(person -> {
			personRepository.delete(person);
			System.out.println(String.format("Person %s deleted", person));
		}, () -> System.out.println(String.format("Error: Person with id %s not found.", id)));

		scanner.close();

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
