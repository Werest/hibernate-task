package ru.werest.hibernatetask.dao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PERSONS", schema = "PUBLIC")
@IdClass(ContactPerson.class)
public class Person {
    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "surname")
    private String surname;

    @Id
    @Column(name = "age")
    private Integer age;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 50)
    private String cityLiving;
}
