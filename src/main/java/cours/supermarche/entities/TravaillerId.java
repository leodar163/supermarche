package cours.supermarche.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class TravaillerId implements Serializable
{
    private static final long serialVersionUID = 5336490575083245513L;
    @Column(name = "codeE", nullable = false)
    private Integer idEmploye;

    @Column(name = "codeR", nullable = false)
    private Integer idRayon;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Integer getIdEmploye()
    {
        return idEmploye;
    }

    public void setIdEmploye(Integer idEmploye)
    {
        this.idEmploye = idEmploye;
    }

    public Integer getIdRayon()
    {
        return idRayon;
    }

    public void setIdRayon(Integer idRayon)
    {
        this.idRayon = idRayon;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TravaillerId entity = (TravaillerId) o;
        return Objects.equals(this.date, entity.date) &&
                Objects.equals(this.idRayon, entity.idRayon) &&
                Objects.equals(this.idEmploye, entity.idEmploye);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(date, idRayon, idEmploye);
    }

}