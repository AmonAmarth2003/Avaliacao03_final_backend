package com.example.avaliacao03_final.controllers;

import com.example.avaliacao03_final.dtos.PatientErrorDto;
import com.example.avaliacao03_final.dtos.PatientRequestDto;
import com.example.avaliacao03_final.dtos.PatientResponseDto;
import com.example.avaliacao03_final.services.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping
    @ResponseBody
    public PatientResponseDto insertPatient(@RequestBody PatientRequestDto patientRequestDto){
        return patientService.insertPatient(patientRequestDto);
    }
    @GetMapping
    @ResponseBody
    //Should not return a list of the model
    public List<PatientResponseDto> returnPatients(){
        return patientService.returnPatients();
    }

    //doesn't work, don't know why tho
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public PatientErrorDto error(HttpServletRequest req, EntityNotFoundException ex) {
        return new PatientErrorDto(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
    }

}
