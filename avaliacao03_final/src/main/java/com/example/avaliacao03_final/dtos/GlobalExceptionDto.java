package com.example.avaliacao03_final.dtos;

import org.springframework.http.HttpStatus;

public record GlobalExceptionDto(HttpStatus status, String reason ) {}



