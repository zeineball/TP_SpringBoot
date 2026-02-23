package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Universite;
import com.example.workshopassociations.services.UniversiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Universite")
public class UniversiteController {
    private final UniversiteService UniversiteServiceImpl;

    public UniversiteController(UniversiteService UniversiteServiceImpl) {
        this.UniversiteServiceImpl = UniversiteServiceImpl;
    }
    @GetMapping("/all")
    public List<Universite> getAllUniversite( ){
        return UniversiteServiceImpl.getAllUniversites();
    }

    @PostMapping("/ajouterUniversite")
    public Universite addUniversite(@RequestBody Universite Universite){
        return UniversiteServiceImpl.saveUniversite(Universite);
    }
    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversite(@PathVariable Long id){
        UniversiteServiceImpl.deleteUniversite(id);
    }

    @GetMapping("/getUniversite/{id}")
    public Universite  getUniversite(@PathVariable Long id){
        return UniversiteServiceImpl.getUniversiteById(id);
    }
}
