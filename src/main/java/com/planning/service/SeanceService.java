package com.planning.service;

import com.planning.model.Seance;
import com.planning.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeanceService {
    @Autowired private SeanceRepository seanceRepository;
    public List<Seance> getAllSeances() { return seanceRepository.findAll(); }
    public void saveSeance(Seance seance) { seanceRepository.save(seance); }
    public Seance getSeanceById(int id) { return seanceRepository.findById(id).orElse(null); }
    public void deleteSeance(int id) { seanceRepository.deleteById(id); }
}
