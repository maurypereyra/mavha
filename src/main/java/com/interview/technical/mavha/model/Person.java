package com.interview.technical.mavha.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
public class Person implements Serializable {
    @Id
    @Min(value=1, message = "entity.person.id.lessThanMin")
    @Max(value=100000000, message = "entity.person.id.moreThanMax")
    private Long id;
    @NotNull(message = "entity.person.name.null")
    @Pattern(regexp = "^[a-z-A-Z\\D]+$", message = "entity.person.name.badFormat")
    @Size(min = 1, message = "entity.person.name.empty")
    private String name;
    @NotNull(message = "entity.person.lastName.null")
    @Pattern(regexp = "^[a-z-A-Z\\D]+$", message = "entity.person.lastName.badFormat")
    @Size(min = 1, message = "entity.person.lastName.empty")
    private String lastName;
    @NotNull
    @Min(value = 0, message = "entity.person.age.invalid")
    @Max(value = 123, message = "entity.person.age.invalid")
    private Integer age;
}

