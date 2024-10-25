package cours.supermarche.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "secteur", schema = "bddsupermarche")
public class Secteur
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numS", nullable = false)
    private Integer id;

    @Column(name = "nomS", nullable = false, length = 250)
    private String nom;

    @OneToMany(mappedBy = "numSecteur")
    private Set<Rayon> rayons = new LinkedHashSet<>();

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

    public Set<Rayon> getRayons()
    {
        return rayons;
    }

    public void setRayons(Set<Rayon> rayons)
    {
        this.rayons = rayons;
    }

}