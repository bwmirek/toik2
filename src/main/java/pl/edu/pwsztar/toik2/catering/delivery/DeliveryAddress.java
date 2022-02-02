package pl.edu.pwsztar.toik2.catering.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private String zipCode;
    private String addressLine;
}
