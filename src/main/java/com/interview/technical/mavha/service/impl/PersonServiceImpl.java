package com.interview.technical.mavha.service.impl;

import com.interview.technical.mavha.exception.PersonAlreadyExist;
import com.interview.technical.mavha.model.Person;
import com.interview.technical.mavha.repo.PersonRepository;
import com.interview.technical.mavha.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person create(Person person) {
        Optional<Person> optPersona = personRepository.findOneById(person.getId());
        if (optPersona.isPresent()) {
            LOGGER.error(String.format("Person already exists with id=%d", person.getId()));
            throw new PersonAlreadyExist(person.getId());
        }
        return personRepository.save(person);
    }
}
