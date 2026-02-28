package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.entities.typeC;
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

    @GetMapping("/allJPQL")
    public List<Chambre> getAllChambresJPQL(){
        return chambreServiceImpl.GetAllChambresJPQL();
    }

    @GetMapping("/allSimple")
    public List<Chambre> getAllChambresSIMPLE(){
        return chambreServiceImpl.GetAllChambresSIMPLE();
    }

    @GetMapping("/allByEtudiant")
    public List<Chambre> getAllChambresByEtudiant(Long idEtudiant){
        return chambreServiceImpl.GetAllChambresByEtudiant(idEtudiant);
    }

    @GetMapping("/allByUniversite")
    public List<Chambre> getAllChambresByUniversite(String nomUniversite){
        return chambreServiceImpl.GetAllChambresByFoyerUniversite(nomUniversite);
    }

    @GetMapping("/countChambreByType/{type}")
    public Long CountChambresByTypeC(@PathVariable("type") typeC type){
        return chambreServiceImpl.CountChambresByTypeC(type);
    }

    @GetMapping("/allByNumChambre")
    public List<Chambre> getAllChambresByNumChambre(){
        return chambreServiceImpl.GetAllChambresByNumChambre();
    }



}