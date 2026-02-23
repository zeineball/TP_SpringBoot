package com.example.workshopassociations.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    typeC TypeChambre;

    @ManyToOne
    Bloc bloc;

    @OneToMany
    List<Reservation> reservations;
}
