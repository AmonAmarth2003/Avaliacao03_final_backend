package com.example.avaliacao03_final.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record ConsultResponseDto(UUID id, LocalDate date, UUID doctor_id, UUID patient_id) { }
