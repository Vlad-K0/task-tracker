package com.vladko.tasktrackerbackend.dto;

import lombok.Builder;

@Builder
public record SaveUserResponseDTO(
        Long id,
        String email
) {
}
