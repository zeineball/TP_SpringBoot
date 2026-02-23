package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Universite;

import java.util.List;

public interface UniversiteService {
    Universite saveUniversite(Universite universite);
    void deleteUniversite(Long idUniversite);
    List<Universite> getAllUniversites();
    Universite getUniversiteById(Long idUniversite);
}
