package cours.supermarche.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "travailler", schema = "bddsupermarche")
public class Travailler
{
    @EmbeddedId
    private TravaillerId id;

    @MapsId("idEmploye")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codeE", nullable = false)
    private Employe employe;

    @MapsId("idRayon")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codeR", nullable = false)
    private Rayon rayon;

    @ColumnDefault("0")
    @Column(name = "temps")
    private Integer dureeHeure;

    public TravaillerId getId()
    {
        return id;
    }

    public void setId(TravaillerId id)
    {
        this.id = id;
    }

    public Employe getEmploye()
    {
        return employe;
    }

    public void setEmploye(Employe employe)
    {
        this.employe = employe;
    }

    public Rayon getRayon()
    {
        return rayon;
    }

    public void setRayon(Rayon rayon)
    {
        this.rayon = rayon;
    }

    public Integer getDureeHeure()
    {
        return dureeHeure;
    }

    public void setDureeHeure(Integer dureeHeure)
    {
        this.dureeHeure = dureeHeure;
    }

}