package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Foyer;

import java.util.List;

public interface FoyerService {
    Foyer saveFoyer(Foyer foyer);
    void deleteFoyer(Long idFoyer);
    List<Foyer> getAllFoyer();
    Foyer getFoyerById(Long idFoyer);
}
