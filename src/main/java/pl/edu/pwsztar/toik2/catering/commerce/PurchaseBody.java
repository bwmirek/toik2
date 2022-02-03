package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Reprezentacja zamówienia wysyłanego na serwer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseBody {
    /**
     * ID zamówionej diety
     */
    private Long dietId;

    /**
     * Liczba zamówionych tygodnii
     */
    private int weeks;

    /**
     * Imię zamawiającego
     */
    private String name;

    /**
     * Nazwisko zamawiającego
     */
    private String surname;

    /**
     * E-mail zamawiającego
     */
    private String email;

    /**
     * ID miasta z zamóienia
     */
    private Long cityId;

    /**
     * Kod pocztowy zamówienia
     */
    private String zipCode;

    /**
     * Adres zamówienia
     */
    private String addressLine;
}
