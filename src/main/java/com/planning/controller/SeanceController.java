package com.planning.controller;

import com.planning.model.Seance;
import com.planning.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/SeanceAction")
public class SeanceController {
    @Autowired private SeanceService seanceService;
    @Autowired private PlanningService planningService;
    @Autowired private EnseignantService enseignantService;
    @Autowired private CoursService coursService;
    @Autowired private SalleService salleService;

    @GetMapping
    public String listSeances(Model model) {
        model.addAttribute("seances", seanceService.getAllSeances());
        model.addAttribute("plannings", planningService.getAllPlannings());
        model.addAttribute("enseignants", enseignantService.getAllEnseignants());
        model.addAttribute("coursList", coursService.getAllCours());
        model.addAttribute("salles", salleService.getAllSalles());
        return "seances";
    }

    @PostMapping
    public String addSeance(@ModelAttribute Seance seance) {
        seanceService.saveSeance(seance);
        return "redirect:/SeanceAction";
    }

    @GetMapping("/delete")
    public String deleteSeance(@RequestParam int id) {
        seanceService.deleteSeance(id);
        return "redirect:/SeanceAction";
    }
}
