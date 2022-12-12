package com.krugerstar.medicaltests.services;

import com.krugerstar.medicaltests.entities.MedicalTest;
import com.krugerstar.medicaltests.repositories.MedicalTestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalTestServiceImpl implements MedicalTestService{
    @Autowired
    private MedicalTestsRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalTest> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MedicalTest> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public MedicalTest save(MedicalTest test) {
        return repository.save(test);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MedicalTest> findByIdPatient(Long idPatient) {
        return repository.findByIdPatient(idPatient);
    }
}
