package cours.supermarche.controllers;

import cours.supermarche.entities.Secteur;
import cours.supermarche.services.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecteurController
{
    @Autowired
    private SecteurService secteurService;

    @GetMapping("/secteurs/all")
    @ResponseBody
    public List<Secteur> getAllSecteurs()
    {
        return secteurService.getAllSecteurs();
    }

    @GetMapping("/secteur/{secteurid}")
    @ResponseBody
    public Secteur getSecteurById(@PathVariable int secteurid)
    {
        return secteurService.getSecteurById(secteurid);
    }
}
