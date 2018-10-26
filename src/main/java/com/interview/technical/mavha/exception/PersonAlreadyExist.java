package com.interview.technical.mavha.exception;


import org.springframework.http.HttpStatus;

public class PersonAlreadyExist extends ServiceException {

    public PersonAlreadyExist(Long id) {
        super(ErrorCodes.INVALID_ARGUMENTS,
                "person.exist.exception.message",
                "person.exist.exception.description",
                HttpStatus.BAD_REQUEST);
    }

}
