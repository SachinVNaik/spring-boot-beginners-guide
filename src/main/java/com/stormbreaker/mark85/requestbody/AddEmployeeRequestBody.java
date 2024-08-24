package com.stormbreaker.mark85.requestbody;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;


@Getter
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
