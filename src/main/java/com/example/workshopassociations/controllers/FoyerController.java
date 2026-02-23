package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Foyer;
import com.example.workshopassociations.services.FoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Foyer")
public class FoyerController {
    private final FoyerService FoyerServiceImpl;

    public FoyerController(FoyerService FoyerServiceImpl) {
        this.FoyerServiceImpl = FoyerServiceImpl;
    }
    @GetMapping("/all")
    public List<Foyer> getAllFoyer( ){
        return FoyerServiceImpl.getAllFoyer();
    }

    @PostMapping("/ajouterFoyer")
    public Foyer addFoyer(@RequestBody Foyer Foyer){
        return FoyerServiceImpl.saveFoyer(Foyer);
    }
    @DeleteMapping("/deleteFoyer/{id}")
    public void deleteFoyer(@PathVariable Long id){
        FoyerServiceImpl.deleteFoyer(id);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer  getFoyer(@PathVariable Long id){
        return FoyerServiceImpl.getFoyerById(id);
    }
}
