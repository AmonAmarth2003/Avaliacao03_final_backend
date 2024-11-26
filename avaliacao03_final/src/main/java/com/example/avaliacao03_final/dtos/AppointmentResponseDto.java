package com.example.avaliacao03_final.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record AppointmentResponseDto(UUID id, LocalDate date, UUID doctor_id, UUID patient_id) { }
