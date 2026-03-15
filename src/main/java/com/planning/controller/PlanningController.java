package com.planning.controller;

import com.planning.model.Planning;
import com.planning.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/PlanningList")
public class PlanningController {
    @Autowired private PlanningService planningService;
    @GetMapping
    public String listPlannings(Model model) {
        model.addAttribute("plannings", planningService.getAllPlannings());
        return "planning";
    }

    @PostMapping
    public String addPlanning(@ModelAttribute Planning planning) {
        planningService.savePlanning(planning);
        return "redirect:/PlanningList";
    }

    @GetMapping("/delete")
    public String deletePlanning(@RequestParam int id) {
        planningService.deletePlanning(id);
        return "redirect:/PlanningList";
    }
}
