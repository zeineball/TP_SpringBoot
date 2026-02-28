package com.example.workshopassociations.repository;

import com.example.workshopassociations.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {

    @Query("SELECT f FROM Foyer f WHERE f.capaciteFoyer > 500")
    List<Foyer> findAllFoyers500();


}
