package com.example.Patient_sevice.mapper;

import com.example.Patient_sevice.DTO.PatientRequestDTO;
import com.example.Patient_sevice.DTO.PatientResponseDTO;
import com.example.Patient_sevice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDTO;
    }
   public static Patient toModel(PatientRequestDTO patientRequestDTO)
   {
       Patient patient = new Patient();
       patient.setName(patientRequestDTO.getName());
       patient.setAddress(patientRequestDTO.getAddress());
       patient.setEmail(patientRequestDTO.getEmail());
       patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
       patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
       return patient;
   }

}
