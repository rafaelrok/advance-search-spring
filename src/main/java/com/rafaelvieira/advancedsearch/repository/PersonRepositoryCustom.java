package com.rafaelvieira.advancedsearch.repository;


import com.rafaelvieira.advancedsearch.dto.PersonFilter;
import com.rafaelvieira.advancedsearch.entity.Person;
import org.springframework.data.domain.Page;

public interface PersonRepositoryCustom {

    Page<Person> persons(PersonFilter filter);

}
