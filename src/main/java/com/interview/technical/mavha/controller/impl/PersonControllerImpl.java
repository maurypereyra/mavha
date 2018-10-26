package com.interview.technical.mavha.controller.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.interview.technical.mavha.controller.PersonController;
import com.interview.technical.mavha.dto.PersonRequest;
import com.interview.technical.mavha.dto.PersonResponse;
import com.interview.technical.mavha.model.Person;
import com.interview.technical.mavha.service.PersonService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonControllerImpl implements PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private MapperFacade orikaMapper;

    @Override
    public List<PersonResponse> readAllPersons() {
        return orikaMapper.mapAsList(personService.getAll(), PersonResponse.class);
    }

    @Override
    public PersonResponse createPerson(@NotNull Long id, @NotNull @Valid PersonRequest personRequest) {
        Person person = orikaMapper.map(personRequest, Person.class);
        person.setId(id);
        return orikaMapper.map(personService.create(person), PersonResponse.class);
    }

}
