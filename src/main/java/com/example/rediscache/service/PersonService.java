package com.example.rediscache.service;

import com.example.rediscache.domain.Person;
import com.example.rediscache.repository.PersonRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    @Cacheable(value = "persons")
    public List<Person> read() {
        return repository.findAll();
    }

    @Cacheable(value="person", key="#id")
    public Optional<Person> find(String id) {
        return repository.findById(id);
    }
}
