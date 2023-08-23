package ru.werest.hibernatetask.service;

import org.springframework.stereotype.Service;
import ru.werest.hibernatetask.dao.Person;
import ru.werest.hibernatetask.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
