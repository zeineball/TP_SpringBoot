package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.entities.typeC;

import java.util.List;

public interface ChambreService {
    Chambre saveChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    Chambre getChambreById(Long idCambre);
    List<Chambre> GetAllChambre();
    List<Chambre> GetAllChambresJPQL();
    List<Chambre> GetAllChambresSIMPLE();
    List<Chambre> GetAllChambresByFoyerUniversite(String nomUniversite);
    Long CountChambresByTypeC(typeC typeC);
    List<Chambre> GetAllChambresByNumChambre();
    List<Chambre> GetAllBytypeChambre(typeC tc);
    List<Chambre> GetAllByBlocIdBloc(Long idBloc);
    Chambre GetChambreByNumeroChambre(Long numeroChambre);
    List<Chambre> GetAllByNumeroChambreAndTypeChambre(Long numeroChambre, typeC TypeChambre);
    List<Chambre> GetAllByBlocNomBloc(String nomBloc);
    int GetCountBytypeChambreAndBlocIdBloc(typeC TypeChambre, Long idBloc);





}
