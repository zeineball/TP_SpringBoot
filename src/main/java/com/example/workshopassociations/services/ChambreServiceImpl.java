package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

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
}

