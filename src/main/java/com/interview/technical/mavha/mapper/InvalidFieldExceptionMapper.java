package com.interview.technical.mavha.mapper;

import java.util.Locale;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

@Singleton
@Provider
public class InvalidFieldExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Inject
    private MessageSource messageSource;

    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(HttpStatus.BAD_REQUEST.value())
                .entity(e.getConstraintViolations()
                        .stream()
                        .map(element -> messageSource.getMessage(element.getMessage(),null, Locale.getDefault()))
                        .collect(Collectors.toList()))
                .build();
    }
}

