package pl.edu.pwsztar.toik2.catering.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwsztar.toik2.catering.delivery.CityRepository;
import pl.edu.pwsztar.toik2.catering.delivery.CityResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DietController {
    private final DietRepository dietRepository;

    @RequestMapping("/diets")
    public List<DietResponse> getAllDiets() {
        return dietRepository.findAll().stream().map(DietResponse::from).collect(Collectors.toList());
    }
}