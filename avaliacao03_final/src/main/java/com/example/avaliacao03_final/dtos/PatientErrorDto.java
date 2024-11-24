package com.example.avaliacao03_final.dtos;

import org.springframework.http.HttpStatus;

public record PatientErrorDto( HttpStatus status, String reason ) {}



