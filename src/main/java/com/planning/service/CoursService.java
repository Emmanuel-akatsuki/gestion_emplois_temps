package com.planning.service;

import com.planning.model.Cours;
import com.planning.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoursService {
    @Autowired private CoursRepository coursRepository;
    public List<Cours> getAllCours() { return coursRepository.findAll(); }
    public void saveCours(Cours cours) { coursRepository.save(cours); }
    public Cours getCoursById(int id) { return coursRepository.findById(id).orElse(null); }
    public void deleteCours(int id) { coursRepository.deleteById(id); }
    public long countCours() { return coursRepository.count(); }
}
