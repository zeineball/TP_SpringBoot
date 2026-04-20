package com.example.workshopassociations.services;

import com.example.workshopassociations.entities.Bloc;
import com.example.workshopassociations.entities.Chambre;
import com.example.workshopassociations.entities.typeC;
import com.example.workshopassociations.repository.BlocRepository;
import com.example.workshopassociations.repository.ChambreRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements ChambreService {

    private final ChambreRepository chambreRepository;
    private final BlocRepository blocRepository;


    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre getChambreById(Long idCambre) {
        return chambreRepository.findById(idCambre).orElse(null);
    }

    @Override
    public List<Chambre> GetAllChambre() {
        return chambreRepository.findAll();
    }


    @Override
    public List<Chambre> GetAllChambresJPQL() {
        return chambreRepository.findAllChambresJPQL();
    }
    @Override
    public List<Chambre> GetAllChambresSIMPLE() {
        return chambreRepository.findAllChambresSIMPLE();
    }

    @Override
    public List<Chambre> GetAllChambresByFoyerUniversite(String nomUniversite) {
        return chambreRepository.findAllChambresByFoyerUniversite(nomUniversite);
    }

    @Override
    public Long CountChambresByTypeC(typeC type) {
        return chambreRepository.CountChambresByType(type);
    }

    @Override
    public List<Chambre> GetAllChambresByNumChambre() {
        return chambreRepository.findAllChambresByNumChambre();
    }

    @Override
    public List<Chambre> GetAllBytypeChambre(typeC tc) {
        return chambreRepository.findBytypeChambre(tc);
    }

    @Override
    public List<Chambre> GetAllByBlocIdBloc(Long idBloc) {
        return chambreRepository.findByBlocIdBloc(idBloc);
    }

    @Override
    public Chambre GetChambreByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findChambreByNumeroChambre(numeroChambre);
    }

    @Override
    public List<Chambre> GetAllByNumeroChambreAndTypeChambre(Long numeroChambre, typeC TypeChambre) {
        return chambreRepository.findByNumeroChambreAndTypeChambre(numeroChambre, TypeChambre);
    }

    @Override
    public List<Chambre> GetAllByBlocNomBloc(String nomBloc) {
        return chambreRepository.findByBlocNomBloc(nomBloc);
    }

    @Override
    public int GetCountBytypeChambreAndBlocIdBloc(typeC TypeChambre, Long idBloc) {
        return chambreRepository.countBytypeChambreAndBlocIdBloc(TypeChambre, idBloc);
    }

    // "toutes les minutes" se traduit par 60000ms ou une expression cron
    @Scheduled(fixedRate = 10000)
    public void listeChambresParBloc() {
        List<Bloc> blocs = (List<Bloc>) blocRepository.findAll();

        for (Bloc bloc : blocs) {
            // Ligne 1 : Nom et capacité
            log.info("Bloc => {} ayant une capacité {}", bloc.getNomBloc(), bloc.getCapaciteBloc());

            List<Chambre> chambres = bloc.getChambres();

            if (chambres == null || chambres.isEmpty()) {
                // Cas vide
                log.info("Pas de chambre disponible dans ce bloc");
            } else {
                // Cas avec chambres
                log.info("La liste des chambres pour ce bloc:");
                for (Chambre c : chambres) {
                    log.info("NumChambre: {} type: {}", c.getNumeroChambre(), c.getTypeChambre());
                }
            }
            // Ligne de séparation
            log.info("***********************");
        }
    }

    // Service 02: Se déclenche toutes les 5 minutes (5 * 60 * 1000 = 300000 ms)
    @Scheduled(fixedRate = 10000)
    public void pourcentageChambreParTypeChambre() {
        // 1. Récupérer toutes les chambres de la base
        List<Chambre> toutesLesChambres = chambreRepository.findAll();
        long totalChambres = toutesLesChambres.size();

        // Affichage du nombre total (Format exact de l'image)
        log.info("Nombre total des chambre: {}", totalChambres);

        if (totalChambres > 0) {
            // 2. Parcourir chaque type défini dans l'enum typeC
            for (typeC type : typeC.values()) {
                // Compter combien de chambres ont ce type
                long count = toutesLesChambres.stream()
                        .filter(c -> c.getTypeChambre() != null && c.getTypeChambre().equals(type))
                        .count();

                // 3. Calculer le pourcentage (en double pour avoir la précision .0)
                double pourcentage = (count * 100.0) / totalChambres;

                // Affichage au format exact de l'image
                log.info("Le pourcentage des chambres pour le type {} est égale à {}", type, pourcentage);
            }
        } else {
            log.info("Aucune chambre disponible pour le calcul des pourcentages.");
        }
    }

    // Service 03: Toutes les 5 minutes (300000 ms)
    @Transactional
    @Scheduled(fixedRate = 10000)
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        List<Chambre> chambres = chambreRepository.findAll();

        for (Chambre chambre : chambres) {
            // 1. Déterminer la capacité max selon le type
            int capaciteMax = 0;
            if (chambre.getTypeChambre() != null) {
                switch (chambre.getTypeChambre()) {
                    case SIMPLE: capaciteMax = 1; break;
                    case DOUBLE: capaciteMax = 2; break;
                    case TRIPLE: capaciteMax = 3; break;
                }
            }

            // 2. Compter les réservations actuelles
            int nbReservations = (chambre.getReservations() != null) ? chambre.getReservations().size() : 0;

            // 3. Calculer les places restantes
            int placesDisponibles = capaciteMax - nbReservations;

            // 4. Affichage selon le format de l'image
            if (placesDisponibles <= 0) {
                log.info("La chambre {} {} est complete",
                        chambre.getTypeChambre(), chambre.getNumeroChambre());
            } else {
                log.info("Le nombre de place disponible pour la chambre {} {} est {}",
                        chambre.getTypeChambre(), chambre.getNumeroChambre(), placesDisponibles);
            }
        }
    }

}

