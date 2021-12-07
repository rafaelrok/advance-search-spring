package com.rafaelvieira.advancedsearch.repository;

import com.rafaelvieira.advancedsearch.model.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>, JpaSpecificationExecutor<Person>, PersonRepositoryCustom {

}