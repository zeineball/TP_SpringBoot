package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Etudiant;
import com.example.workshopassociations.repository.EtudiantRepository;
import com.example.workshopassociations.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {


    private final EtudiantRepository etudiantRepository;
    private final ReservationRepository reservationRepository;
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
    public Long CountEtudiantsByUniv() {
        return etudiantRepository.CountEtudiantsByUniv();
    }


    @Override
    public List<Etudiant> getEtudiantsAvecPlusDeReservationsQueMoyenne() {
        long totalEtudiants = etudiantRepository.count();
        long totalReservations = reservationRepository.count();

        // Protection contre la division par zéro
        if (totalEtudiants == 0) return List.of();

        // Calcul de la moyenne en Java
        double moyenne = (double) totalReservations / totalEtudiants;

        // Appel de la requête JPQL simplifiée
        return etudiantRepository.findEtudiantsPlusDeReservationsQue(moyenne);
    }
}

