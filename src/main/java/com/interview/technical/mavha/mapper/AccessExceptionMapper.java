package com.interview.technical.mavha.mapper;

import java.nio.file.AccessDeniedException;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

@Singleton
@Provider
public class AccessExceptionMapper implements ExceptionMapper<AccessDeniedException> {
    @Inject
    private MessageSource messageSource;

    @Override
    public Response toResponse(AccessDeniedException e) {
        return Response.status(HttpStatus.FORBIDDEN.value())
                .entity(new ErrorResponse(HttpStatus.FORBIDDEN.value(),
                        messageSource.getMessage("request.unauthorized.message",
                                null, Locale.getDefault()),
                        messageSource.getMessage("request.unauthorized.description",
                                null, Locale.getDefault())))
                .build();
    }
}
