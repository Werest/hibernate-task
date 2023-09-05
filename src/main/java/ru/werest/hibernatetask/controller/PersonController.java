package ru.werest.hibernatetask.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.werest.hibernatetask.dao.Person;
import ru.werest.hibernatetask.request.PersonRequest;
import ru.werest.hibernatetask.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }


    @GetMapping("/by-city")
    @Secured({"ROLE_READ"})
    public ResponseEntity<List<Person>> getPersonByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(service.getPersonsByCity(city));
    }

    @GetMapping("/by-age-order-asc")
    @RolesAllowed("ROLE_WRITE")
    public ResponseEntity<List<Person>> getPersonByAgeOrderAsc(@RequestParam("age") Integer age) {
        return ResponseEntity.ok(service.getPersonByAgeOrderAsc(age));
    }

    @GetMapping("/by-name-surname")
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    public ResponseEntity<Optional<Person>> getPersonByNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return ResponseEntity.ok(service.getPersonByNameSurname(name, surname));
    }

    @GetMapping("/by-name-surname-username")
    @PostAuthorize("hasAnyRole('ROLE_WRITE')")
    public ResponseEntity<String> ShowUsername(@RequestParam("username")String username) {
        return ResponseEntity.ok("ShowUserNamePost -> " + username);
    }

    @GetMapping("/welcome")
    @PreAuthorize("#username == authentication.principal.username")
    public ResponseEntity<String> getWelcome(String username) {
        return ResponseEntity.ok("Hello " + username);
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody PersonRequest request) {
        service.createPerson(request);
        return ResponseEntity.ok("Пользователь создан!");
    }

    @PutMapping
    public ResponseEntity<String> updatePerson(@RequestBody PersonRequest request) {
        service.updatePerson(request);
        return ResponseEntity.ok("Пользователь обновлен!");
    }

    @DeleteMapping
    public ResponseEntity<String> deletePerson(@RequestBody PersonRequest request) {
        service.deletePerson(request);
        return ResponseEntity.ok("Пользователь удалён!");
    }
}
