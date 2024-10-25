package cours.supermarche.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employe", schema = "bddsupermarche")
public class Employe
{
    @Id
    @Column(name = "numE", nullable = false)
    private Integer id;

    @Column(name = "prenomE", nullable = false, length = 20)
    private String prenom;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "employe")
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

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
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