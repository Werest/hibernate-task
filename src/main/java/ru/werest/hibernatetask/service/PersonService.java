package ru.werest.hibernatetask.service;

import org.springframework.stereotype.Service;
import ru.werest.hibernatetask.dao.Person;
import ru.werest.hibernatetask.repository.PersonRepository;
import ru.werest.hibernatetask.request.PersonRequest;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonByCityLivingJPQL(city);
    }

    public List<Person> getPersonByAgeOrderAsc(Integer age) {
        return repository.getPersonByAgeLessThanOrderByAgeAscJPQL(age);
    }

    public Optional<Person> getPersonByNameSurname(String name, String surname) {
        return repository.getPersonByNameAndSurnameJPQL(name, surname);
    }

    public void createPerson(PersonRequest request) {
        Person person = repository.getPersonByNameAndSurnameAndAgeJPQL(request.getName(), request.getSurname(), request.getAge());
        if (person != null) {
            throw new RuntimeException("Персона существует!");
        } else {
            person = new Person();
            person.setName(request.getName());
            person.setSurname(request.getSurname());
            person.setPhoneNumber(request.getPhoneNumber());
            person.setAge(request.getAge());
            person.setCityLiving(request.getCityLiving());

            repository.save(person);
        }
    }

    public void updatePerson(PersonRequest request) {
        Person person = repository.getPersonByNameAndSurnameAndAgeJPQL(request.getName(), request.getSurname(), request.getAge());
        if (person == null) {
            throw new RuntimeException("Персоны не существует. Сначала создайте!");
        }
        person.setName(request.getName());
        person.setSurname(request.getSurname());
        person.setPhoneNumber(request.getPhoneNumber());
        person.setAge(request.getAge());
        person.setCityLiving(request.getCityLiving());

        repository.save(person);
    }

    public void deletePerson(PersonRequest request) {
        Person person = repository.getPersonByNameAndSurnameAndAgeJPQL(request.getName(), request.getSurname(), request.getAge());
        if (person == null) {
            throw new RuntimeException("Персоны не существует. Сначала создайте!");
        }

        repository.delete(person);
    }
}
