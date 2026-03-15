package com.planning.controller;

import com.planning.model.Utilisateur;
import com.planning.service.UtilisateurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/LoginAction")
    public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
        Optional<Utilisateur> userOpt = utilisateurService.findByLogin(login);
        if (userOpt.isPresent()) {
            Utilisateur user = userOpt.get();
            // In a real app we'd check hashed password, but here we follow legacy logic
            if (user.getPasswordHash().equals(password)) {
                session.setAttribute("user", user);
                return "redirect:/dashboard";
            }
        }
        return "redirect:/login?error=1";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
