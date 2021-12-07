package com.rafaelvieira.advancedsearch.repository;

import com.rafaelvieira.advancedsearch.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/*
@Repository
public interface PersonRepository extends CrudRepository<Person, String>, JpaSpecificationExecutor<Person>, PersonRepositoryCustom {
}
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {

}