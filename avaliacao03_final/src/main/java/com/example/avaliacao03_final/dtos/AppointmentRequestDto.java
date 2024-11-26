package com.example.avaliacao03_final.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record AppointmentRequestDto(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy") @NotNull @FutureOrPresent
        LocalDate date,
        @NotNull @NotBlank UUID doctor_id,
        @NotNull @NotBlank UUID patient_id
) { }
