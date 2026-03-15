package com.planning.controller;

import com.planning.model.Salle;
import com.planning.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/SalleAction")
public class SalleController {
    @Autowired private SalleService salleService;
    @GetMapping
    public String listSalles(Model model) {
        model.addAttribute("salles", salleService.getAllSalles());
        return "salles";
    }
    @PostMapping
    public String addSalle(@ModelAttribute Salle salle) {
        salleService.saveSalle(salle);
        return "redirect:/SalleAction";
    }

    @GetMapping("/delete")
    public String deleteSalle(@RequestParam int id) {
        salleService.deleteSalle(id);
        return "redirect:/SalleAction";
    }
}
