package com.example.workshopassociations.repository;

import com.example.workshopassociations.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc")
    Bloc getBlocByIdJPQL(Long idBolc);

    @Query("SELECT b FROM Bloc b WHERE b.foyer.idFoyer = :idFoyer")
    List<Bloc> getAllBlocsByIdFoyer(Long idFoyer);

    @Query("SELECT b FROM Bloc b JOIN b.chambres c GROUP BY b.idBloc HAVING COUNT(c) > 10")
    List<Bloc> getBlocsBy10Chambres();
}
