package com.interview.technical.mavha.service;

import com.interview.technical.mavha.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person create(Person person);

}
