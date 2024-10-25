package cours.supermarche.repositories;

import cours.supermarche.entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Integer>
{

}
