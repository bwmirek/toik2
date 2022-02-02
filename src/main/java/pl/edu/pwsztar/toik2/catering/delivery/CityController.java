package pl.edu.pwsztar.toik2.catering.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityRepository cityRepository;

    @RequestMapping("/cities")
    public List<CityResponse> getAllCities() {
        return cityRepository.findAll().stream().map(CityResponse::from).collect(Collectors.toList());
    }
}
