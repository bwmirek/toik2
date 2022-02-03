package pl.edu.pwsztar.toik2.catering.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Kontroller obsługujący miasta
 */
@RestController
@RequiredArgsConstructor
public class CityController {
    /**
     * Repozytorium miast
     */
    private final CityRepository cityRepository;

    /**
     * Endpoint zwracający listę miast
     *
     * @return Lista miast
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/cities")
    public List<CityResponse> getAllCities() {
        return cityRepository.findAll().stream().map(CityResponse::from).collect(Collectors.toList());
    }
}
