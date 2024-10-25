package cours.supermarche.services;

import cours.supermarche.entities.Employe;
import cours.supermarche.entities.Rayon;
import cours.supermarche.entities.Travailler;
import cours.supermarche.repositories.EmployeRepository;
import cours.supermarche.repositories.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeService
{
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private RayonRepository rayonRepository;

    public List<Employe> getAllEmployes()
    {
        return employeRepository.findAll();
    }

    public Employe getEmployeById(int employeId)
    {
        return employeRepository.findById(employeId).orElse(null);
    }

    public List<Employe> getEmployesOfRayon(int rayonId)
    {
        Rayon rayon = rayonRepository.findById(rayonId).orElse(null);

        List<Employe> employes = rayon.getShifts().stream().map(Travailler::getEmploye).toList();

        return rayon == null ? null : rayon.getShifts().stream().map(Travailler::getEmploye).toList();
    }
}
