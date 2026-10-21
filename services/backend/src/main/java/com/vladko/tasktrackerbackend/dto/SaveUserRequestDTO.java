package com.vladko.tasktrackerbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SaveUserRequestDTO(
        @Email
        @NotBlank
        @Size(min = 3, max = 255)
        String email,

        @NotNull
        String password
) {
}
