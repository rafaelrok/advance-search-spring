package com.rafaelvieira.advancedsearch.dto;

import com.rafaelvieira.advancedsearch.enums.MaritalStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class PersonFilter {

    private String name;
    private String email;
    private MaritalStatus maritalStatus;
    private String city;
    private String state;
    private String district;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate initialbirthday;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate finalbirthday;
}
