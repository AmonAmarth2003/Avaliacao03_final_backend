package com.example.avaliacao03_final.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;
public record PatientRequestDto(
        @NotNull(message="Patient must contain an id")
        UUID id,
        String medical_history
) {}
