package com.planning.controller;

import com.planning.model.Examen;
import com.planning.service.ExamenService;
import com.planning.service.CoursService;
import com.planning.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ExamenAction")
public class ExamenController {
    @Autowired private ExamenService examenService;
    @Autowired private CoursService coursService;
    @Autowired private SalleService salleService;
    @GetMapping
    public String listExamens(Model model) {
        model.addAttribute("examens", examenService.getAllExamens());
        model.addAttribute("coursList", coursService.getAllCours());
        model.addAttribute("salleList", salleService.getAllSalles());
        return "examens";
    }
    @PostMapping
    public String addExamen(@ModelAttribute Examen examen) {
        examenService.saveExamen(examen);
        return "redirect:/ExamenAction";
    }

    @GetMapping("/delete")
    public String deleteExamen(@RequestParam int id) {
        examenService.deleteExamen(id);
        return "redirect:/ExamenAction";
    }
}
