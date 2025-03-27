package com.example.Patient_sevice.service;

import com.example.Patient_sevice.DTO.PatientRequestDTO;
import com.example.Patient_sevice.DTO.PatientResponseDTO;
import com.example.Patient_sevice.exception.EmailAlreadyExistsException;
import com.example.Patient_sevice.exception.PatientNotFoundException;
import com.example.Patient_sevice.mapper.PatientMapper;
import com.example.Patient_sevice.model.Patient;
import com.example.Patient_sevice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO)
    {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail()))
        {
            throw new EmailAlreadyExistsException(
                    "A patient with this email " + "already exists"
                            + patientRequestDTO.getEmail());
        }
        Patient patient=patientRepository.save(
                PatientMapper.toModel(patientRequestDTO)


        );
        return PatientMapper.toDTO(patient);

    }
    public PatientResponseDTO updatePatient(UUID id,
                                            PatientRequestDTO patientRequestDTO) {

        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with ID: " + id));

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),
                id)) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email " + "already exists"
                            + patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }
    public void deletePatient(UUID id)
    {
        patientRepository.deleteById(id);

    }







}
