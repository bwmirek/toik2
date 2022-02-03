package pl.edu.pwsztar.toik2.catering.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozytorium adresów dostawy
 */
@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {
}
