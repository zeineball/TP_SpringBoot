package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Etudiant;
import com.example.workshopassociations.services.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
    private final EtudiantService EtudiantServiceImpl;

    public EtudiantController(EtudiantService EtudiantServiceImpl) {
        this.EtudiantServiceImpl = EtudiantServiceImpl;
    }
    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant( ){
        return EtudiantServiceImpl.getAllEtudiant();
    }

    @PostMapping("/ajouterEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant Etudiant){
        return EtudiantServiceImpl.saveEtudiant(Etudiant);
    }
    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable Long id){
        EtudiantServiceImpl.deleteEtudiant(id);
    }

    @GetMapping("/getEtudiant/{id}")
    public Etudiant  getEtudiant(@PathVariable Long id){
        return EtudiantServiceImpl.getEtudiantById(id);
    }
}

