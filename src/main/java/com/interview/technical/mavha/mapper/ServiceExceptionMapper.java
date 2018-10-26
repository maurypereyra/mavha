package com.interview.technical.mavha.mapper;

import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.interview.technical.mavha.exception.ServiceException;
import org.springframework.context.MessageSource;

@Singleton
@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

    @Inject
    private MessageSource messageSource;

    @Override
    public Response toResponse(ServiceException exception) {
        return Response.status(exception.getHttpStatus().value())
                .entity(new ErrorResponse(exception.getCode(),
                        messageSource.getMessage(exception.getMessageCode(), null, Locale.getDefault()),
                        messageSource.getMessage(exception.getDescriptionCode(), null, Locale.getDefault())))
                .build();
    }
}
