package com.example.workshopassociations.repository;

import com.example.workshopassociations.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.estValidee = true")
    List<Reservation> findAllReservationsValide();
    @Query("SELECT r FROM Reservation r WHERE YEAR(r.dateReservation) = YEAR(CURRENT_DATE)")
    List<Reservation> findAllReservationsCurrentDate();
}
