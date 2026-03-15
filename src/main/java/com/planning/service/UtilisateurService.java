package com.planning.service;

import com.planning.model.Utilisateur;
import com.planning.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired private UtilisateurRepository utilisateurRepository;
    public List<Utilisateur> getAllUtilisateurs() { return utilisateurRepository.findAll(); }
    public void saveUtilisateur(Utilisateur utilisateur) { utilisateurRepository.save(utilisateur); }
    public Utilisateur getUtilisateurById(int id) { return utilisateurRepository.findById(id).orElse(null); }
    public void deleteUtilisateur(int id) { utilisateurRepository.deleteById(id); }
    public Optional<Utilisateur> findByLogin(String login) { return utilisateurRepository.findByLogin(login); }
}
