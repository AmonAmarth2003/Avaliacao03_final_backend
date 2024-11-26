package com.example.avaliacao03_final.controllers;

import com.example.avaliacao03_final.dtos.AppointmentRequestDto;
import com.example.avaliacao03_final.dtos.AppointmentResponseDto;
import com.example.avaliacao03_final.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping
    @ResponseBody
    public AppointmentResponseDto save(@RequestBody @Valid AppointmentRequestDto request){
        return appointmentService.save(request);
    }

    @GetMapping
    @ResponseBody
    public List<AppointmentResponseDto> findAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AppointmentResponseDto findById(@PathVariable("id") String id) { return appointmentService.findById(UUID.fromString(id)); }

    @DeleteMapping("/{id}")
    @ResponseBody
    public AppointmentResponseDto deleteById(@PathVariable("id") String id) { return appointmentService.deleteById(UUID.fromString(id)); }

    @PatchMapping("/{id}")
    @ResponseBody
    public AppointmentResponseDto patch(@PathVariable("id") String id, @RequestBody AppointmentRequestDto request) { return appointmentService.patch(UUID.fromString(id), request); }
}
