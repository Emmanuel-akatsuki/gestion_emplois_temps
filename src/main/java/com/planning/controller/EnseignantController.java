package com.planning.controller;

import com.planning.model.Enseignant;
import com.planning.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/EnseignantAction")
public class EnseignantController {
    @Autowired private EnseignantService enseignantService;
    @GetMapping
    public String listEnseignants(Model model) {
        model.addAttribute("enseignants", enseignantService.getAllEnseignants());
        return "enseignants";
    }
    @PostMapping
    public String addEnseignant(@ModelAttribute Enseignant enseignant) {
        enseignantService.saveEnseignant(enseignant);
        return "redirect:/EnseignantAction";
    }

    @GetMapping("/delete")
    public String deleteEnseignant(@RequestParam int id) {
        enseignantService.deleteEnseignant(id);
        return "redirect:/EnseignantAction";
    }
}
