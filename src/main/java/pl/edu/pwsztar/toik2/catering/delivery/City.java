package pl.edu.pwsztar.toik2.catering.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Reprezentacja rekordu z miastem
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    /**
     * Unikalny identyfikator
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nazwa miasta
     */
    private String name;
}
