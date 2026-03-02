package com.example.workshopassociations.repository;

import com.example.workshopassociations.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query("SELECT e FROM Etudiant e WHERE e.ecole = 'ESPRIT'")
    List<Etudiant>ListEtudiantsEsprit();

    @Query("SELECT e FROM Etudiant e WHERE YEAR(e.dateNaissance) > 2000")
    List<Etudiant>ListEtudiants2000();


    @Query("SELECT e.ecole, COUNT(e) FROM Etudiant e GROUP BY e.ecole")
    Long CountEtudiantsByUniv();

    @Query("SELECT e FROM Etudiant e JOIN e.reservations r GROUP BY e.idEtudiant HAVING COUNT(r) > :moyenne")
    List<Etudiant> findEtudiantsPlusDeReservationsQue( double moyenne);
}
