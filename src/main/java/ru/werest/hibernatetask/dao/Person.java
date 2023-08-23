package ru.werest.hibernatetask.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PERSONS", schema = "PUBLIC")
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


    @Id
    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Id
    @Column(name = "city_of_living", length = 50)
    private String cityLiving;
}
