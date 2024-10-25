package cours.supermarche.controllers;

import cours.supermarche.entities.Travailler;
import cours.supermarche.entities.TravaillerId;
import cours.supermarche.services.TravaillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class TravaillerController
{
    @Autowired
    private TravaillerService travaillerService;

    @GetMapping("/shifts/rayon/{rayonId}")
    @ResponseBody
    public List<Travailler> getShiftsByRayonId(@PathVariable int rayonId)
    {
        return travaillerService.getShiftsByRayonId(rayonId);
    }

    @GetMapping("/shifts/employe/{employeId}")
    @ResponseBody
    public List<Travailler> getShiftsByEmployeId(@PathVariable int employeId)
    {
        return travaillerService.getShiftsByEmployeId(employeId);
    }

    @PostMapping("/shifts/add")
    public ResponseEntity<Travailler> addShift(@RequestBody Map<String, Object> shift)
    {
        Travailler newShift = new Travailler();
        TravaillerId travaillerId = new TravaillerId();
        travaillerId.setIdRayon((int)(shift.get("idRayon")));
        travaillerId.setIdEmploye((int)(shift.get("idEmploye")));
        travaillerId.setDate((LocalDate)(shift.get("date")));
        newShift.setId(travaillerId);
        newShift.setDureeHeure((int)(shift.get("dureeHeure")));

        newShift = travaillerService.addShift(newShift);

        return new ResponseEntity<>(newShift, newShift == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
}
