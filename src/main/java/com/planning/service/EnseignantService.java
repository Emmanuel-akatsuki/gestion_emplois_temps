package com.planning.service;

import com.planning.model.Enseignant;
import com.planning.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnseignantService {
    @Autowired private EnseignantRepository enseignantRepository;
    public List<Enseignant> getAllEnseignants() { return enseignantRepository.findAll(); }
    public void saveEnseignant(Enseignant enseignant) { enseignantRepository.save(enseignant); }
    public Enseignant getEnseignantById(int id) { return enseignantRepository.findById(id).orElse(null); }
    public void deleteEnseignant(int id) { enseignantRepository.deleteById(id); }
    public long countEnseignants() { return enseignantRepository.count(); }
}
