package com.planning.service;

import com.planning.model.Planning;
import com.planning.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanningService {
    @Autowired private PlanningRepository planningRepository;
    public List<Planning> getAllPlannings() { return planningRepository.findAll(); }
    public void savePlanning(Planning planning) { planningRepository.save(planning); }
    public Planning getPlanningById(int id) { return planningRepository.findById(id).orElse(null); }
    public void deletePlanning(int id) { planningRepository.deleteById(id); }
}
