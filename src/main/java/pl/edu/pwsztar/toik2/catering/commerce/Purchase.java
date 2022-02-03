package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pwsztar.toik2.catering.delivery.DeliveryAddress;
import pl.edu.pwsztar.toik2.catering.restaurant.Diet;

import javax.persistence.*;
import java.util.Date;

/**
 * Reprezentacja rekordu zamówienia z bazy danych
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    /**
     * Identyfikator
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Data utworzenia
     */
    private Date createdAt;

    /**
     * ID zamówionej diety
     */
    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    /**
     * ID adresu dostawy
     */
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private DeliveryAddress deliveryAddress;

    /**
     * Okres zamówionej diety
     */
    private int weeks;

    /**
     * Status zamówienia
     */
    private String status;
}
