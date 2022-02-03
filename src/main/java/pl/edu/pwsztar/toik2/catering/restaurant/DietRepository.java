package pl.edu.pwsztar.toik2.catering.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozytorium diet
 */
@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
}
