package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.entities.typeC;
import com.example.workshopassociations.services.ChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Gestion Chambre")
@RestController
@RequestMapping("/chambres")
public class ChambreController {

    private final ChambreService chambreServiceImpl;

    public ChambreController(ChambreService chambreServiceImpl) {
        this.chambreServiceImpl = chambreServiceImpl;
    }

    @Operation(description = "Create and save a new Chambre in the system.")
    @PostMapping("/ajouterChambre")
    public Chambre saveChambre(@RequestBody Chambre chambre){
        return chambreServiceImpl.saveChambre(chambre);
    }

    @Operation(description = "Delete a Chambre by its unique identifier.")
    @DeleteMapping("/deleteChambre/{id}")
    public void deleteChambre(@PathVariable("id") Long idChambre){
        chambreServiceImpl.deleteChambre(idChambre);
    }

    @Operation(description = "Retrieve a Chambre by its unique identifier.")
    @GetMapping("/getChambre/{id}")
    public Chambre getChambreById(@PathVariable("id") Long idChambre) {
        return chambreServiceImpl.getChambreById(idChambre);
    }

    @Operation(description = "Retrieve the list of all Chambres using the default repository method.")
    @GetMapping("/all")
    public List<Chambre> getAllChambres() {
        return chambreServiceImpl.GetAllChambre();
    }

    @Operation(description = "Retrieve all Chambres using a JPQL query.")
    @GetMapping("/allJPQL")
    public List<Chambre> getAllChambresJPQL(){
        return chambreServiceImpl.GetAllChambresJPQL();
    }

    @Operation(description = "Retrieve all Chambres of typeC SIMPLE.")
    @GetMapping("/allSimple")
    public List<Chambre> getAllChambresSIMPLE(){
        return chambreServiceImpl.GetAllChambresSIMPLE();
    }

    @Operation(description = "Retrieve all Chambres associated with a specific Universite through its foyer name.")
    @GetMapping("/allByUniversite")
    public List<Chambre> getAllChambresByUniversite(String nomUniversite){
        return chambreServiceImpl.GetAllChambresByFoyerUniversite(nomUniversite);
    }

    @Operation(description = "Count the number of Chambres by a given type (typeC).")
    @GetMapping("/countChambreByType/{type}")
    public Long CountChambresByTypeC(@PathVariable("type") typeC type){
        return chambreServiceImpl.CountChambresByTypeC(type);
    }

    @Operation(description = "Retrieve all Chambres ordered or filtered by room number.")
    @GetMapping("/allByNumChambre")
    public List<Chambre> getAllChambresByNumChambre(){
        return chambreServiceImpl.GetAllChambresByNumChambre();
    }



}