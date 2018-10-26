package com.interview.technical.mavha.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonRequest {
    @NotNull(message = "entity.person.name.null")
    @Pattern(regexp = "^[a-z-A-Z\\D]+$", message = "entity.person.name.badFormat")
    @Size(min = 1, message = "entity.person.name.empty")
    private String name;
    @NotNull(message = "entity.person.lastName.null")
    @Pattern(regexp = "^[a-z-A-Z\\D]+$", message = "entity.person.lastName.badFormat")
    @Size(min = 1, message = "entity.person.lastName.empty")
    private String lastName;
    @NotNull(message = "entity.person.age.null")
    @Min(value = 0, message = "entity.person.age.invalid")
    @Max(value = 123, message = "entity.person.age.invalid")
    private Integer age;
}
