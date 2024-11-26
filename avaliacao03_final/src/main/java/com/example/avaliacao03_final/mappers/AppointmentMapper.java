package com.example.avaliacao03_final.mappers;

import com.example.avaliacao03_final.dtos.AppointmentRequestDto;
import com.example.avaliacao03_final.dtos.AppointmentResponseDto;
import com.example.avaliacao03_final.models.AppointmentModel;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public AppointmentResponseDto toDto(AppointmentModel appointment){
        return new AppointmentResponseDto(
                appointment.getId(),
                appointment.getDate(),
                appointment.getDoctor().getId(),
                appointment.getPatient().getId()
        );
    }
}
