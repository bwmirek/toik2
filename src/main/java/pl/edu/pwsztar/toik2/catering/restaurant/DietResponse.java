package pl.edu.pwsztar.toik2.catering.restaurant;

import lombok.Builder;
import lombok.Getter;

/**
 * Odpowiedź serwera z dietą
 */
@Getter
@Builder
public class DietResponse {
    /**
     * ID diety
     */
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

    /**
     * Funkcja budujące odpowiedź serwera z reprezentacji rekordu diety
     *
     * @param diet Rekord diety
     * @return Reprezentacja odpowiedzi serwera
     */
    public static DietResponse from(Diet diet) {
        return DietResponse.builder()
                .id(diet.getId())
                .weeklyPrice(diet.getWeeklyPrice())
                .image(diet.getImage())
                .name(diet.getName())
                .description(diet.getDescription())
                .build();
    }
}
