package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.entities.typeC;
import com.example.workshopassociations.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements ChambreService {

    private final ChambreRepository chambreRepository;


    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre getChambreById(Long idCambre) {
        return chambreRepository.findById(idCambre).orElse(null);
    }

    @Override
    public List<Chambre> GetAllChambre() {
        return chambreRepository.findAll();
    }


    @Override
    public List<Chambre> GetAllChambresJPQL() {
        return chambreRepository.findAllChambresJPQL();
    }
    @Override
    public List<Chambre> GetAllChambresSIMPLE() {
        return chambreRepository.findAllChambresSIMPLE();
    }

    @Override
    public List<Chambre> GetAllChambresByEtudiant(Long idEtudiant) {
        return chambreRepository.findAllChambresReservedByEtudiant(idEtudiant);
    }

    @Override
    public List<Chambre> GetAllChambresByFoyerUniversite(String nomUniversite) {
        return chambreRepository.findAllChambresByFoyerUniversite(nomUniversite);
    }

    @Override
    public Long CountChambresByTypeC(typeC type) {
        return chambreRepository.CountChambresByType(type);
    }

    @Override
    public List<Chambre> GetAllChambresByNumChambre() {
        return chambreRepository.findAllChambresByNumChambre();
    }

}

