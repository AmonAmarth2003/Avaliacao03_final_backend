package com.example.avaliacao03_final.dtos;

import jakarta.validation.constraints.NotBlank;

public record PersonRequestDto(@NotBlank(message="name cannot be empty") String name,
                               String contact,
                               String gender) { }
