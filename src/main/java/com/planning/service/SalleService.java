package com.planning.service;

import com.planning.model.Salle;
import com.planning.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalleService {
    @Autowired private SalleRepository salleRepository;
    public List<Salle> getAllSalles() { return salleRepository.findAll(); }
    public void saveSalle(Salle salle) { salleRepository.save(salle); }
    public Salle getSalleById(int id) { return salleRepository.findById(id).orElse(null); }
    public void deleteSalle(int id) { salleRepository.deleteById(id); }
    public long countSalles() { return salleRepository.count(); }
}
