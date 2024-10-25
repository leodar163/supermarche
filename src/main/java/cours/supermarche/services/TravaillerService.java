package cours.supermarche.services;

import cours.supermarche.entities.Travailler;
import cours.supermarche.repositories.TravaillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TravaillerService
{
    @Autowired
    private TravaillerRepository travaillerRepository;

    public List<Travailler> getShiftsByRayonId(int rayonId)
    {
        List<Travailler> shifts = travaillerRepository.findAll();
        return shifts.stream().filter(shift -> shift.getRayon().getId() == rayonId).toList();
    }

    public List<Travailler> getShiftsByEmployeId(int employeId)
    {
        List<Travailler> shifts = travaillerRepository.findAll();
        return shifts.stream().filter(shift -> shift.getEmploye().getId() == employeId).toList();
    }

    public Travailler addShift(Travailler shift)
    {
        return travaillerRepository.save(shift);
    }
}
