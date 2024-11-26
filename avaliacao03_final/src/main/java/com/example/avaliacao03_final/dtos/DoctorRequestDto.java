package com.example.avaliacao03_final.dtos;

import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record DoctorRequestDto(
        String specialization,
        UUID id
) { }
