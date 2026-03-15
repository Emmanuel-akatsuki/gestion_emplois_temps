package com.planning.service;

import com.planning.model.Examen;
import com.planning.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExamenService {
    @Autowired private ExamenRepository examenRepository;
    public List<Examen> getAllExamens() { return examenRepository.findAll(); }
    public void saveExamen(Examen examen) { examenRepository.save(examen); }
    public Examen getExamenById(int id) { return examenRepository.findById(id).orElse(null); }
    public void deleteExamen(int id) { examenRepository.deleteById(id); }
}
