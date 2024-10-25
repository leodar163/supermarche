package cours.supermarche.services;

import cours.supermarche.entities.Rayon;
import cours.supermarche.entities.Secteur;
import cours.supermarche.repositories.RayonRepository;
import cours.supermarche.repositories.SecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RayonService
{
    @Autowired
    private RayonRepository rayonRepository;

    @Autowired
    private SecteurRepository secteurRepository;

    public List<Rayon> getAllRayon()
    {
        return rayonRepository.findAll();
    }

    public List<Rayon> getRayonBySecteur(int idSecteur)
    {
        Secteur secteur = secteurRepository.findById(idSecteur).orElse(null);
        return secteur == null ? null : secteur.getRayons().stream().toList();
    }

    public Rayon getRayonById(int idRayon)
    {
        return rayonRepository.findById(idRayon).orElse(null);
    }
}
