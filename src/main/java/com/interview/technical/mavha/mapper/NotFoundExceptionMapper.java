package com.interview.technical.mavha.mapper;

import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

@Singleton
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Inject
    private MessageSource messageSource;

    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(HttpStatus.NOT_FOUND.value())
                .entity(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                        messageSource.getMessage("entity.notFound.message", null, Locale.getDefault()),
                        messageSource.getMessage("entity.notFound.description", null, Locale.getDefault())))
                .build();
    }
}
