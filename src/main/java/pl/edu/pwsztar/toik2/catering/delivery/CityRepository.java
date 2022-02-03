package pl.edu.pwsztar.toik2.catering.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozytorium miast
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
