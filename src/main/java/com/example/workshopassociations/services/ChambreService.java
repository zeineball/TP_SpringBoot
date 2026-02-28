package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.entities.typeC;

import java.util.List;

public interface ChambreService {
    Chambre saveChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    Chambre getChambreById(Long idCambre);
    List<Chambre> GetAllChambre();
    List<Chambre> GetAllChambresJPQL();
    List<Chambre> GetAllChambresSIMPLE();
    List<Chambre> GetAllChambresByEtudiant(Long idEtudiant);
    List<Chambre> GetAllChambresByFoyerUniversite(String nomUniversite);
    Long CountChambresByTypeC(typeC typeC);
    List<Chambre> GetAllChambresByNumChambre();
}
