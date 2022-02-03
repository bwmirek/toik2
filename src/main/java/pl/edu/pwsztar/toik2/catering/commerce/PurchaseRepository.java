package pl.edu.pwsztar.toik2.catering.commerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozytorium zamówień
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
