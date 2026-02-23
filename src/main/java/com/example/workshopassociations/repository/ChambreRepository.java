package com.example.workshopassociations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.workshopassociations.entities.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    // You can define custom query methods here if needed
}
