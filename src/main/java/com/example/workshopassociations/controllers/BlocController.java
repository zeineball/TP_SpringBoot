package com.example.workshopassociations.controllers;

import com.example.workshopassociations.entities.Bloc;
import com.example.workshopassociations.services.BlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocController {
    private final BlocService blocServiceImpl;

    public BlocController(BlocService blocServiceImpl) {
        this.blocServiceImpl = blocServiceImpl;
    }
    @GetMapping("/all")
    public List<Bloc> getAllBloc( ){
        return blocServiceImpl.getAllBloc();
    }

    @PostMapping("/ajouterBloc")
    public Bloc addbloc(@RequestBody Bloc bloc){
        return blocServiceImpl.saveBloc(bloc);
    }
    @DeleteMapping("/deleteBloc/{id}")
    public void deleteBloc(@PathVariable Long id){
        blocServiceImpl.deleteBloc(id);
    }

    @GetMapping("/getBloc/{id}")
    public Bloc  getBloc(@PathVariable Long id){
       return blocServiceImpl.getBlocById(id);
    }
}
