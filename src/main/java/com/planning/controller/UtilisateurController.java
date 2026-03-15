package com.planning.controller;

import com.planning.model.Utilisateur;
import com.planning.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/RegisterAction")
    public String registerUser(@RequestParam String login, @RequestParam String password, @RequestParam String role) {
        Utilisateur user = new Utilisateur();
        user.setLogin(login);
        user.setPasswordHash(password);
        user.setRole(role);
        user.setActif(true);
        utilisateurService.saveUtilisateur(user);
        return "redirect:/login";
    }
}
