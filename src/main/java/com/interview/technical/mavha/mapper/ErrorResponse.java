package com.interview.technical.mavha.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private Integer code;
    private String message;
    private String description;
}

