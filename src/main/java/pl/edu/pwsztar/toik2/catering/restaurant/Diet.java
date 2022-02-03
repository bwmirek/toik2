package pl.edu.pwsztar.toik2.catering.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Reprezentacja diety w bazie
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diet {
    /**
     * Unikalne ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Tygodniowa cena
     */
    private int weeklyPrice;
    /**
     * Zdjęcie diety
     */
    private String image;
    /**
     * Nazwa diety
     */
    private String name;
    /**
     * Opis diety
     */
    private String description;
}
