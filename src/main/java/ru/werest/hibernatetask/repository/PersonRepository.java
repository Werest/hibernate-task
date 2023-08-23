package ru.werest.hibernatetask.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.werest.hibernatetask.dao.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("SELECT t FROM Person t WHERE t.cityLiving = :city")
                .setParameter("city", city)
                .getResultList();
    }
}
