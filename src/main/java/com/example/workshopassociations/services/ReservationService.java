package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    void deleteReservation(Long idReservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long idReservation);
}
