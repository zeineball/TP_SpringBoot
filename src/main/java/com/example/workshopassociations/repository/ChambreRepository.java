package com.example.workshopassociations.repository;

import com.example.workshopassociations.entities.typeC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.workshopassociations.entities.Chambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findBytypeChambre(typeC tc);

    List<Chambre> findByBlocIdBloc(Long idBloc);

    Chambre findChambreByNumeroChambre(Long numeroChambre);

    List<Chambre> findByNumeroChambreAndTypeChambre(Long numeroChambre, typeC TypeChambre);

    List<Chambre> findByBlocNomBloc(String nomBloc);

    int countBytypeChambreAndBlocIdBloc(typeC TypeChambre, Long idBloc);

    // 1.Récupérer toutes les chambres
    @Query("SELECT c FROM Chambre c")
    List<Chambre> findAllChambresJPQL();

    @Query("SELECT c FROM Chambre c WHERE c.typeChambre = 'SIMPLE'")
    List<Chambre> findAllChambresSIMPLE();


    @Query("SELECT c FROM Chambre c JOIN c.bloc b JOIN b.foyer f WHERE f.universite.nomUniversite = :nomUniversite")
    List<Chambre> findAllChambresByFoyerUniversite(String nomUniversite);

    @Query("SELECT c.typeChambre, COUNT(c) FROM Chambre c GROUP BY c.typeChambre")
    Long CountChambresByType(typeC type);

    @Query("SELECT c FROM Chambre c WHERE c.numeroChambre > (SELECT AVG(c2.numeroChambre) FROM Chambre c2)")
    List<Chambre> findAllChambresByNumChambre();
}
