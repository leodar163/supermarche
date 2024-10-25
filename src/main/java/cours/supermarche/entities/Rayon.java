package cours.supermarche.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rayon", schema = "bddsupermarche")
public class Rayon
{
    @Id
    @Column(name = "numR", nullable = false)
    private Integer id;

    @Column(name = "nomR", nullable = false, length = 20)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numSecteur", nullable = false)
    private Secteur secteur;

    @OneToMany(mappedBy = "rayon")
    @JsonIgnore
    private Set<Travailler> shifts = new LinkedHashSet<>();

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public Secteur getSecteur()
    {
        return secteur;
    }

    public void setSecteur(Secteur secteur)
    {
        this.secteur = secteur;
    }

    public Set<Travailler> getShifts()
    {
        return shifts;
    }

    public void setShifts(Set<Travailler> shifts)
    {
        this.shifts = shifts;
    }

}