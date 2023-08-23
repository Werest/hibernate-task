package ru.werest.hibernatetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.werest.hibernatetask.dao.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> getPersonByCityLiving(String city);

    List<Person> getPersonByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<Person> getPersonByNameAndSurname(String name, String surname);

    Person getPersonByNameAndSurnameAndAge(String name, String surname, Integer age);
}
