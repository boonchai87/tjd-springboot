package com.thaiitwork.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
   /* @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String email;*/

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column()
    @NotBlank(message = "Email is mandatory")
    private String email;

    // standard getters and setters
}
