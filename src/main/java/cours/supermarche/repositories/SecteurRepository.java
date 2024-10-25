package cours.supermarche.repositories;

import cours.supermarche.entities.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer>
{

}
