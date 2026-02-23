package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Bloc;

import java.util.List;

public interface BlocService {
    Bloc saveBloc(Bloc bloc);
    void deleteBloc(Long idBloc);
    Bloc getBlocById(Long idBloc);
    List<Bloc> getAllBloc();

}
