package ru.werest.hibernatetask.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactPerson implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
