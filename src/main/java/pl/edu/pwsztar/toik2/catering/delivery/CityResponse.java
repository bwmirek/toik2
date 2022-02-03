package pl.edu.pwsztar.toik2.catering.delivery;

import lombok.Builder;
import lombok.Getter;

/**
 * Odpowiedź serwera z miastem
 */
@Getter
@Builder
public class CityResponse {
    /**
     * ID miasta
     */
    private Long id;
    /**
     * Nazwa miasta
     */
    private String name;

    /**
     * Funkcja generująca odpowiedź z miastem z reprezentacji danych
     *
     * @param city Reprezentacja danych z bazy
     * @return Odpowiedź serwera z miastem
     */
    public static CityResponse from(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
