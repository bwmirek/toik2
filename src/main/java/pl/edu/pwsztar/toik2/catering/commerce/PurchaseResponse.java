package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.*;

/**
 * Reprezentacja odpowiedzi serwera z zamówieniem
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    /**
     * Cena tygodniowa
     */
    private int weeklyPrice;
    /**
     * Nazwa diety
     */
    private String diet;

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
     * Miasto
     */
    private String city;
    /**
     * Kod pocztowy
     */
    private String zipCode;
    /**
     * adres dostawy
     */
    private String addressLine;

    /**
     * Funkcja tworzące obiekt reprezentacji z obiektu encji
     *
     * @param purchase Encja zamówienia
     * @return Reprezentacja odpowiedzi serwera z zamówieniem
     */
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
