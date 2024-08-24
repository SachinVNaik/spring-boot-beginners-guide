package com.stormbreaker.mark85.requestbody;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;


@Getter
// only a getter is enough on request body classes
// do not use setters as thees values should only be set from request, not from code
public class AddEmployeeRequestBody {

    @Length(max = 20, message = "first name cannot exceed 20 characters")
    @NotNull(message = "first name cannot be null.")
    @NotBlank(message = "first name cannot be empty.")
    private String firstName;

    @Length(max = 20, message = "last name cannot exceed 20 characters")
    @NotNull(message = "last name cannot be null.")
    @NotBlank(message = "last name cannot be empty.")
    private String lastName;

    @NotBlank(message = "email cannot be blank.")
    @NotNull(message = "email cannot be null.")
    private String email;
}
