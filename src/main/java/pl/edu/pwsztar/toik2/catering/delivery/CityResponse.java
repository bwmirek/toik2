package pl.edu.pwsztar.toik2.catering.delivery;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CityResponse {
    private Long id;
    private String name;

    public static CityResponse from(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
