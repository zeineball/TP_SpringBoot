package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Etudiant;
import com.example.workshopassociations.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {


    private final EtudiantRepository etudiantRepository;
    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiantsEsprit(){
        return etudiantRepository.ListEtudiantsEsprit();
    }

    @Override
    public List<Etudiant> getAllEtudiants2000() {
        return etudiantRepository.ListEtudiants2000();
    }

    @Override
    public List<Etudiant> getAllEtudiantsByFoyer(Long idFoyer) {
        return etudiantRepository.ListEtudiantsByFoyer(idFoyer);
    }

    @Override
    public Long CountEtudiantsByUniv() {
        return etudiantRepository.CountEtudiantsByUniv();
    }

    @Override
    public List<Etudiant> getAllEtudiantsReservation() {
        return etudiantRepository.ListEtudiantsReservations();
    }
}
