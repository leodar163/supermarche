package cours.supermarche.repositories;

import cours.supermarche.entities.Travailler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravaillerRepository extends JpaRepository<Travailler, Integer>
{

}
