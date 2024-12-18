package com.example.avaliacao03_final.controllers;

import com.example.avaliacao03_final.dtos.PatientRequestDto;
import com.example.avaliacao03_final.dtos.PatientResponseDto;
import com.example.avaliacao03_final.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponseDto save(@RequestBody PatientRequestDto patientRequestDto){
        return patientService.save(patientRequestDto);
    }
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<PatientResponseDto> findAll(){
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PatientResponseDto findById(@PathVariable("id") String id){
        return patientService.findById(UUID.fromString(id));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PatientResponseDto deleteById(@PathVariable("id") String id){
        return patientService.deleteById(UUID.fromString(id));
    }

    @PatchMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PatientResponseDto patch(@PathVariable("id") String id, @RequestBody PatientRequestDto patientRequestDto){
        return patientService.patch(UUID.fromString(id), patientRequestDto);
    }
}
