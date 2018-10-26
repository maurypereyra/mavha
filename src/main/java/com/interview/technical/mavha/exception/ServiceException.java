package com.interview.technical.mavha.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class ServiceException extends RuntimeException {
    private Integer code;
    private String messageCode;
    private String descriptionCode;
    private HttpStatus httpStatus;
}
