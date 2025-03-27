package com.example.Patient_sevice.controller;

import com.example.Patient_sevice.DTO.PatientRequestDTO;
import com.example.Patient_sevice.DTO.PatientResponseDTO;
import com.example.Patient_sevice.model.Patient;
import com.example.Patient_sevice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO>patients=patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }
    @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO)
    {
        PatientResponseDTO patients= patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patients);

    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,@RequestBody PatientRequestDTO patientRequestDTO)
    {
        PatientResponseDTO patientResponseDTO=patientService.updatePatient(id,patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
