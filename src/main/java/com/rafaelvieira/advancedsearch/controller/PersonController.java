package com.rafaelvieira.advancedsearch.controller;

import com.rafaelvieira.advancedsearch.dto.PersonFilter;
import com.rafaelvieira.advancedsearch.entity.Person;
import com.rafaelvieira.advancedsearch.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @GetMapping
    public List<Person> findAll() {

        return this.personService.findAll();
    }

    @GetMapping("/search")
    public Page<Person> findAll(PersonFilter filter, Pageable pageable) {
        return this.personService.findAll(filter, pageable);
    }

}
