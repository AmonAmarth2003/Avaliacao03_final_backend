package com.example.avaliacao03_final.mappers;

import com.example.avaliacao03_final.dtos.ConsultResponseDto;
import com.example.avaliacao03_final.models.ConsultModel;
import org.springframework.stereotype.Component;

@Component
public class ConsultMapper {
    public ConsultResponseDto toDto(ConsultModel appointment){
        return new ConsultResponseDto(
                appointment.getId(),
                appointment.getDate(),
                appointment.getDoctor().getId(),
                appointment.getPatient().getId()
        );
    }
}
