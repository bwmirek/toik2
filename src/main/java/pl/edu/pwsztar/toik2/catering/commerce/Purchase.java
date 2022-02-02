package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pwsztar.toik2.catering.delivery.DeliveryAddress;
import pl.edu.pwsztar.toik2.catering.restaurant.Diet;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private DeliveryAddress deliveryAddress;

    private int weeks;
    private String status;
}
