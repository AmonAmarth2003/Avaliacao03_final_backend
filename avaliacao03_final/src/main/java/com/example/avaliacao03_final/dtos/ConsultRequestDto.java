package com.example.avaliacao03_final.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record ConsultRequestDto(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
        @NotNull(message = "Date cannot be null")
        @FutureOrPresent(message = "Date cannot be before today")
        //Doesn't contain default error for incorrect data input in date
        LocalDate date,
        @NotNull(message="A doctor is expected in a consultation") UUID doctor_id,
        @NotNull(message="A patient is expected in a consultation") UUID patient_id
) { }
