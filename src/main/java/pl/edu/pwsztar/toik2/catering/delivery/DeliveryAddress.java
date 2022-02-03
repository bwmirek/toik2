package pl.edu.pwsztar.toik2.catering.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Reprezentacja adresu dostawy w bazie
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddress {
    /**
     * Unikalne ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Imię zamawiającego
     */
    private String name;
    /**
     * Nazwisko zamawiającego
     */
    private String surname;
    /**
     * Email zamawiającego
     */
    private String email;

    /**
     * Miasto zamawiającego
     */
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    /**
     * Kod pocztowy zamawiającego
     */
    private String zipCode;
    /**
     * Adres dostawy zamawiającego
     */
    private String addressLine;
}
