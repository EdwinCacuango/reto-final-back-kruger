package com.krugerstar.medicaltests.controllers;

import com.krugerstar.medicaltests.entities.MedicalTest;
import com.krugerstar.medicaltests.services.MedicalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/medical-tests")
public class MedicalTestController {
    @Autowired
    public MedicalTestService service;

    @GetMapping
    public List<MedicalTest> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<MedicalTest> o=service.findById(id);
        if(o.isPresent()){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Get test by idPatient
    @GetMapping("/patient/{idPatient}")
    public List<MedicalTest> findByIdPatient(@PathVariable Long idPatient){
        return service.findByIdPatient(idPatient);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MedicalTest test){
        if(test.getOxygenLevel()>0
                && test.getOxygenLevel()<=100
                &&test.getSugarLevel()>0
                && test.getSugarLevel()<=100
                && test.getFatLevel()>0
                && test.getFatLevel()<=100
        ){
            if(test.getOxygenLevel()< 60
                    && test.getSugarLevel()> 70
                    && test.getFatLevel() > 88.25)
            {
                test.setMedicalRisk("HIGH");

            } else if (test.getOxygenLevel() > 60
                    && test.getOxygenLevel() < 70
                    && test.getSugarLevel() > 50
                    && test.getSugarLevel() < 70
                    && test.getFatLevel() > 62.2
                    && test.getFatLevel() < 88.5)
            {
                test.setMedicalRisk("MEDIUM");

            } else if (test.getOxygenLevel() > 70
                    && test.getSugarLevel() < 50
                    && test.getFatLevel() < 62.2)
            {
                test.setMedicalRisk("LOW");
            }

            test.setMedicalRisk(test.getMedicalRisk());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(test));
        }else {
            return ResponseEntity.badRequest().body("Niveles de azúcar, grasa o de oxígeno fuera de rango");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody MedicalTest test, @PathVariable Long id){
        Optional<MedicalTest> o = service.findById(id);
        if(o.isPresent()) {
            MedicalTest testDb= o.get();
            if(test.getSugarLevel() > 0 && test.getSugarLevel() <= 100){
                testDb.setSugarLevel(test.getSugarLevel());
            }else{
                return ResponseEntity.badRequest().body("Niveles de azucar fuera de rango");
            }
            if(test.getOxygenLevel()> 0 && test.getOxygenLevel()<=100){
                testDb.setOxygenLevel(test.getOxygenLevel());
            }else{
                return ResponseEntity.badRequest().body("Niveles de oxígeno fuera de rango");
            }
            if(test.getFatLevel() > 0 && test.getFatLevel()<=100){
                testDb.setFatLevel(test.getFatLevel());
            }else{
                return ResponseEntity.badRequest().body("Niveles de grasa fuera de rango");
            }
            testDb.setIdPatient(test.getIdPatient());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(testDb));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<MedicalTest> o= service.findById(id);
        if(o.isPresent()){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
