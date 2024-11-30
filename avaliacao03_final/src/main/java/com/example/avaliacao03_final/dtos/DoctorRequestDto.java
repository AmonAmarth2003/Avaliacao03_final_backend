package com.example.avaliacao03_final.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DoctorRequestDto(
        @NotNull(message="Doctor must contain an id")
        UUID id,
        @NotBlank(message = "Doctor must be specialized")
        String specialization
) { }
