package com.example.Patient_sevice.service;

import com.example.Patient_sevice.DTO.PatientResponseDTO;
import com.example.Patient_sevice.mapper.PatientMapper;
import com.example.Patient_sevice.model.Patient;
import com.example.Patient_sevice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository=patientRepository;
    }
    public List<PatientResponseDTO> getPatients()
    {
        List<Patient>patients=patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();

    }



}
