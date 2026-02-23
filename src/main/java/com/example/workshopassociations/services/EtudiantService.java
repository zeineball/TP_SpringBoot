package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long idEtudiant);
    List<Etudiant> getAllEtudiant();
    Etudiant getEtudiantById(Long idEtudiant);
}
