package pl.edu.pwsztar.toik2.catering.restaurant;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DietResponse {
    private Long id;
    private int weeklyPrice;
    private String image;
    private String name;
    private String description;

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
