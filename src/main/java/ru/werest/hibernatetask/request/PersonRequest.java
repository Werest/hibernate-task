package ru.werest.hibernatetask.request;

import lombok.Data;

@Data
public class PersonRequest {
    private String name;
    private String surname;
    private Integer age;
    private String phoneNumber;
    private String cityLiving;
}
