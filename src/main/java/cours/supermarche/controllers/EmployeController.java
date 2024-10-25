package cours.supermarche.controllers;

import cours.supermarche.entities.Employe;
import cours.supermarche.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeController
{
    @Autowired
    private EmployeService employeService;

    @GetMapping("/employes/all")
    @ResponseBody
    public List<Employe> getAllEmploye()
    {
        return employeService.getAllEmployes();
    }

    @GetMapping("/employe/{employeId}")
    @ResponseBody
    public Employe getEmployeById(@PathVariable int employeId)
    {
        return employeService.getEmployeById(employeId);
    }

    @GetMapping("/employes/rayon/{rayonId}")
    @ResponseBody
    public List<Employe> getEmployesOfRayon(@PathVariable int rayonId)
    {
        return employeService.getEmployesOfRayon(rayonId);
    }
}
