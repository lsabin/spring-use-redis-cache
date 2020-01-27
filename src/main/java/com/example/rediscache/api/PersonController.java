package com.example.rediscache.api;

import com.example.rediscache.domain.Person;
import com.example.rediscache.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public String insert(@RequestParam String key, @RequestParam String value) {
        Person person = new Person();
        person.setName(value);

        Person saved = service.save(person);

        return "saved " + saved.getId() + ":" + saved.getName();
    }

    @GetMapping("all")
    public List<Person> read() {
        return service.read();
    }

    @GetMapping
    public Person get(@RequestParam String key) {
        Optional<Person> person = service.find(key);

        return person.orElse(null);
    }



}
