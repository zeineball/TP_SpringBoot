package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Chambre;

import java.util.List;

public interface ChambreService {
    Chambre saveChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    Chambre getChambreById(Long idCambre);
    List<Chambre> GetAllChambre();
}
