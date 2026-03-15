package com.planning.controller;

import com.planning.model.Etudiant;
import com.planning.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/EtudiantAction")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public String listEtudiants(Model model) {
        List<Etudiant> list = etudiantService.getAllEtudiants();
        model.addAttribute("etudiants", list);
        return "etudiants";
    }

    @PostMapping
    public String addEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantService.saveEtudiant(etudiant);
        return "redirect:/EtudiantAction";
    }

    @GetMapping("/delete")
    public String deleteEtudiant(@RequestParam int id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/EtudiantAction";
    }
}
