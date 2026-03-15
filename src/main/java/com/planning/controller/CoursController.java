package com.planning.controller;

import com.planning.model.Cours;
import com.planning.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/CoursAction")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @GetMapping
    public String listCours(Model model) {
        List<Cours> list = coursService.getAllCours();
        model.addAttribute("coursList", list);
        return "cours";
    }

    @PostMapping
    public String addCours(@ModelAttribute Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/CoursAction";
    }

    @GetMapping("/delete")
    public String deleteCours(@RequestParam int id) {
        coursService.deleteCours(id);
        return "redirect:/CoursAction";
    }
}
