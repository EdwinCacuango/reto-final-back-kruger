package com.krugerstar.patients.controllers;

import com.krugerstar.patients.entities.Patient;
import com.krugerstar.patients.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/patients")
public class PatientsController {
    @Autowired
    public PatientsService service;

    //Get all patients
    @GetMapping
    public List<Patient> findAll(){
        return service.findAll();
    }

    //Get a patient by id
    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<Patient> o = service.findById(id);
        if(o.isPresent()){
            return ResponseEntity.ok().body(o.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Save a new patient
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient save(@RequestBody Patient patient){
        return service.save(patient);
    }

    //Update patient by id
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Patient patient, @PathVariable Long id){
        Optional<Patient> o = service.findById(id);
        if(o.isPresent()) {
            Patient patientDb= o.get();
            patientDb.setName(patient.getName());
            patientDb.setMedicalRisk(patient.getMedicalRisk());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(patientDb));
        }
        return ResponseEntity.notFound().build();
    }

    //Delete one patient by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Patient> o = service.findById(id);
        if(o.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }








}
