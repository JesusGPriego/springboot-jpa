package com.suleware.springboot.jpa.springboot_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "persons")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String lastname;
    @Column(name = "programming_language")
    @NonNull
    private String programmingLanguage;
    @Embedded
    private Audit audit = new Audit();

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

}