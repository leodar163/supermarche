package cours.supermarche.controllers;

import cours.supermarche.entities.Rayon;
import cours.supermarche.services.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RayonController
{
    @Autowired
    private RayonService rayonService;

    @GetMapping("/rayons/all")
    @ResponseBody
    public List<Rayon> getAllRayons()
    {
        List<Rayon> rayons = rayonService.getAllRayon();
        return rayons;
    }

    @GetMapping("/rayon/{idRayon}")
    @ResponseBody
    public Rayon getRayonById(@PathVariable int idRayon)
    {
        return rayonService.getRayonById(idRayon);
    }

    @GetMapping("/rayons/secteur/{idSecteur}")
    @ResponseBody
    public List<Rayon> getRayonsOfSecteur(@PathVariable int idSecteur)
    {
        return rayonService.getRayonBySecteur(idSecteur);
    }
}
