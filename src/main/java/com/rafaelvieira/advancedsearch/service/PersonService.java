package com.rafaelvieira.advancedsearch.service;

import com.rafaelvieira.advancedsearch.entity.Person;
import com.rafaelvieira.advancedsearch.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }
}
