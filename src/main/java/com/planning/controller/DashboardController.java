package com.planning.controller;

import com.planning.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired private CoursService coursService;
    @Autowired private EnseignantService enseignantService;
    @Autowired private SalleService salleService;
    @Autowired private EtudiantService etudiantService;
    @Autowired private ExamenService examenService;

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("cours", coursService.countCours());
        model.addAttribute("enseignants", enseignantService.countEnseignants());
        model.addAttribute("salles", salleService.countSalles());
        model.addAttribute("etudiants", etudiantService.countEtudiants());
        model.addAttribute("examen", 0);
        model.addAttribute("cm", 10);
        model.addAttribute("td", 5);
        model.addAttribute("tp", 3);

        return "dashboard";
    }
}
