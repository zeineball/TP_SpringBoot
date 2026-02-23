package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Universite;
import com.example.workshopassociations.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;
    @Override
    public Universite saveUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(Long idUniversite) {

    }

    @Override
    public List<Universite> getAllUniversites() {
        return List.of();
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        return null;
    }
}
