package com.example.avaliacao03_final.dtos;

import java.util.UUID;

public record PatientResponseDto(UUID id, String name, String contact, String gender, String medical_history, UUID person_id) {}