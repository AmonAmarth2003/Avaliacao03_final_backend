package com.example.avaliacao03_final.controllers;

import com.example.avaliacao03_final.dtos.DoctorRequestDto;
import com.example.avaliacao03_final.dtos.DoctorResponseDto;
import com.example.avaliacao03_final.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    @PostMapping
    @ResponseBody
    public DoctorResponseDto save(@RequestBody DoctorRequestDto doctorRequestDto){
        return doctorService.save(doctorRequestDto);
    }

    @GetMapping
    @ResponseBody
    public List<DoctorResponseDto> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public DoctorResponseDto findById(@PathVariable("id") String id){
        return doctorService.findById(UUID.fromString(id));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public DoctorResponseDto deleteById(@PathVariable("id") String id){
        return doctorService.deleteById(UUID.fromString(id));
    }

}

