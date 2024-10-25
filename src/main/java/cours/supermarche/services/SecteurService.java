package cours.supermarche.services;

import cours.supermarche.entities.Secteur;
import cours.supermarche.repositories.SecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService
{
    @Autowired
    private SecteurRepository secteurRepository;

    public List<Secteur> getAllSecteurs()
    {
        return secteurRepository.findAll();
    }

    public Secteur getSecteurById(int id)
    {
        return secteurRepository.findById(id).orElse(null);
    }
}
