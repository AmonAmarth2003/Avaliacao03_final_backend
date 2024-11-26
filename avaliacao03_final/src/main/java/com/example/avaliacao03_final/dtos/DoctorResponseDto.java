package com.example.avaliacao03_final.dtos;

import java.util.UUID;

public record DoctorResponseDto(
        UUID id,
        String name,
        String contact,
        String gender,
        String specialization,
        UUID user_id
) { }
