package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Bloc;
import com.example.workshopassociations.repository.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements BlocService{

    @Autowired
    BlocRepository  blocRepository;

    @Override
    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc getBlocById(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocByIdJPQL(Long idBloc) {
        return blocRepository.getBlocByIdJPQL(idBloc);
    }

    @Override
    public List<Bloc> getAllBlocsByIdFoyer(Long idFoyer) {
        return blocRepository.getAllBlocsByIdFoyer(idFoyer);
    }

    @Override
    public List<Bloc> getBlocsBy10Chambres() {
        return blocRepository.getBlocsBy10Chambres();
    }
}
