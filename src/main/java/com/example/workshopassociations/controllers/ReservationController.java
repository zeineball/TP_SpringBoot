package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Reservation;
import com.example.workshopassociations.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
    private final ReservationService ReservationServiceImpl;

    public ReservationController(ReservationService ReservationServiceImpl) {
        this.ReservationServiceImpl = ReservationServiceImpl;
    }
    @GetMapping("/all")
    public List<Reservation> getAllReservation( ){
        return ReservationServiceImpl.getAllReservations();
    }

    @PostMapping("/ajouterReservation")
    public Reservation addReservation(@RequestBody Reservation Reservation){
        return ReservationServiceImpl.saveReservation(Reservation);
    }
    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable Long id){
        ReservationServiceImpl.deleteReservation(id);
    }

    @GetMapping("/getReservation/{id}")
    public Reservation  getReservation(@PathVariable Long id){
        return ReservationServiceImpl.getReservationById(id);
    }
}
