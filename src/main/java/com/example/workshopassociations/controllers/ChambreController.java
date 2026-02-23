package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.services.ChambreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreController {

    private final ChambreService chambreServiceImpl;

    public ChambreController(ChambreService chambreServiceImpl) {
        this.chambreServiceImpl = chambreServiceImpl;
    }

    @PostMapping("/ajouterChambre")
    public Chambre saveChambre(@RequestBody Chambre chambre){
        return chambreServiceImpl.saveChambre(chambre);
    }

    @DeleteMapping("/deleteChambre/{id}")
    public void deleteChambre(@PathVariable("id") Long idChambre){
        chambreServiceImpl.deleteChambre(idChambre);
    }

    @GetMapping("/getChambre/{id}")
    public Chambre getChambreById(@PathVariable("id") Long idChambre) {
        return chambreServiceImpl.getChambreById(idChambre);
    }

    @GetMapping("/all")
    public List<Chambre> getAllChambres() {
        return chambreServiceImpl.GetAllChambre();
    }

}