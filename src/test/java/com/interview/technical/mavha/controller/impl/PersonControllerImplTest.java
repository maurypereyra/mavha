package com.interview.technical.mavha.controller.impl;

import com.interview.technical.mavha.dto.PersonResponse;
import com.interview.technical.mavha.model.Person;
import com.interview.technical.mavha.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sun.dc.path.PathError;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonControllerImpl.class)
public class PersonControllerImplTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private PersonService personService;

    private PersonControllerImpl personController;

    public void setUp() {

    }

    //TODO Make it work
    @Test
    public void readAllPersons() throws Exception {
        PersonResponse personResponse = PersonResponse.builder().id(1l).age(10).lastName("Perez").name("Juan").build();
        List<PersonResponse> allPeople = Collections.singletonList(personResponse);

        given(personController.readAllPersons()).willReturn(allPeople);

        mvc.perform(get("/api/person")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
        //        .andExpect(jsonPath("$[0].city", is(arrival.getCity())))
        ;



    }

    @Test
    public void createPerson() {
    }
}