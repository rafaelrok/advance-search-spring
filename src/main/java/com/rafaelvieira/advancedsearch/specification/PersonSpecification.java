package com.rafaelvieira.advancedsearch.specification;

import com.rafaelvieira.advancedsearch.dto.PersonFilter;
import com.rafaelvieira.advancedsearch.entity.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonSpecification {

    public Specification<Person> persons(PersonFilter filter) {
        return (root, query, criteriaBuilder) -> {
          List<Predicate> predicateList = new ArrayList<>();
          //Pesquisa o nome por qualquer parte
          //criteriaBuilder.upper utilizado para fazer a pesquisa em maiúsculas
          if(!ObjectUtils.isEmpty(filter.getName())) {
              predicateList.add(
                      criteriaBuilder.like(
                              criteriaBuilder.upper(
                              root.get("name")), filter.getName().toUpperCase().concat("%")
                      )
              );
          }
          //Pesquisa por email
          if(!ObjectUtils.isEmpty(filter.getEmail())) {
              predicateList.add(
                      criteriaBuilder.like(
                              criteriaBuilder.lower(
                                      root.get("email")), filter.getName().toLowerCase().concat("%")
                      )
                );
          }
          //Comparação por estado civil
          if(!ObjectUtils.isEmpty(filter.getMaritalStatus())) {
              predicateList.add(
                      criteriaBuilder.equal(
                                      root.get("maritalStatus"), filter.getMaritalStatus())
              );
          }
          //Filtro por distrito
            if(!ObjectUtils.isEmpty(filter.getDistrict())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(
                                        root.get("district")), filter.getDistrict().toUpperCase().concat("%")
                        )
                );
            }
            //Filtro por cidade
            if(!ObjectUtils.isEmpty(filter.getCity())) {
                predicateList.add(
                        criteriaBuilder.equal(
                                root.get("city"), filter.getCity())
                );
            }
            //Filtro por estado
            if(!ObjectUtils.isEmpty(filter.getState())) {
                predicateList.add(
                        criteriaBuilder.equal(
                                root.get("state"), filter.getState())
                );
            }
            //Compara o ano de aniversário inicial
            //greaterThanOrEqualTo utilizado para comparar o ano de aniversário inicial funciona como um
            //Between com lessThanOrEqualTo
            if(!ObjectUtils.isEmpty(filter.getInitialbirthday())) {
                predicateList.add(
                        criteriaBuilder.greaterThanOrEqualTo(
                                root.get("birthday"), filter.getInitialbirthday())
                );
            }
            //Compara o ano de aniversario final
            if(!ObjectUtils.isEmpty(filter.getFinalbirthday())) {
                predicateList.add(
                        criteriaBuilder.lessThanOrEqualTo(
                                root.get("birthday"), filter.getFinalbirthday())
                );
            }

            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
        };
    }
}
