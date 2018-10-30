package com.interview.technical.mavha.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
}
