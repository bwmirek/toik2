package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.*;
import pl.edu.pwsztar.toik2.catering.delivery.City;
import pl.edu.pwsztar.toik2.catering.delivery.CityResponse;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    private int weeklyPrice;
    private String diet;

    private String name;
    private String surname;
    private String email;

    private String city;
    private String zipCode;
    private String addressLine;

    public static PurchaseResponse from(Purchase purchase) {
        return PurchaseResponse.builder()
                .weeklyPrice(purchase.getDiet().getWeeklyPrice())
                .diet(purchase.getDiet().getName())

                .name(purchase.getDeliveryAddress().getName())
                .surname(purchase.getDeliveryAddress().getSurname())
                .email(purchase.getDeliveryAddress().getEmail())

                .city(purchase.getDeliveryAddress().getCity().getName())
                .zipCode(purchase.getDeliveryAddress().getZipCode())
                .addressLine(purchase.getDeliveryAddress().getAddressLine())
                .build();
    }
}
