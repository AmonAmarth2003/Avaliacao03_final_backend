package com.example.avaliacao03_final.controllers;

import com.example.avaliacao03_final.dtos.ConsultRequestDto;
import com.example.avaliacao03_final.dtos.ConsultResponseDto;
import com.example.avaliacao03_final.services.ConsultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultation")
public class ConsultController {
    @Autowired
    ConsultService consultationService;
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultResponseDto save(@RequestBody @Valid ConsultRequestDto request){
        return consultationService.save(request);
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ConsultResponseDto> findAll(){
        return consultationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ConsultResponseDto findById(@PathVariable("id") String id) { return consultationService.findById(UUID.fromString(id)); }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ConsultResponseDto deleteById(@PathVariable("id") String id) { return consultationService.deleteById(UUID.fromString(id)); }

    @PatchMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ConsultResponseDto patch(@PathVariable("id") String id, @RequestBody ConsultRequestDto request) { return consultationService.patch(UUID.fromString(id), request); }
}
