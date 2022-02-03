package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.toik2.catering.delivery.City;
import pl.edu.pwsztar.toik2.catering.delivery.CityRepository;
import pl.edu.pwsztar.toik2.catering.delivery.DeliveryAddress;
import pl.edu.pwsztar.toik2.catering.delivery.DeliveryAddressRepository;
import pl.edu.pwsztar.toik2.catering.restaurant.Diet;
import pl.edu.pwsztar.toik2.catering.restaurant.DietRepository;
import pl.edu.pwsztar.toik2.catering.security.User;
import pl.edu.pwsztar.toik2.catering.security.UserBody;
import pl.edu.pwsztar.toik2.catering.security.UserRepository;


import java.nio.file.AccessDeniedException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Kontroler obsługujący zamówienia
 */
@RestController
@RequiredArgsConstructor
public class PurchaseController {
    /**
     * Repozytorium miast
     */
    private final CityRepository cityRepository;
    /**
     * Repozytorium diet
     */
    private final DietRepository dietRepository;
    /**
     * Repozytorium adresów dostawy
     */
    private final DeliveryAddressRepository deliveryAddressRepository;
    /**
     * Repozytorium zakupów
     */
    private final PurchaseRepository purchaseRepository;
    /**
     * Repozytorium użytkowników
     */
    private final UserRepository userRepository;

    /**
     * Endpoint służący do składania zamówień
     *
     * @param purchaseBody obiekt zawierający informacje o zamówieniu
     * @return ID nowozłożonego zamówienia
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/purchase")
    public Map<String, Long> purchase(@RequestBody PurchaseBody purchaseBody) {
        Diet diet = dietRepository.findById(purchaseBody.getDietId()).orElseThrow();
        City city = cityRepository.findById(purchaseBody.getCityId()).orElseThrow();

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setName(purchaseBody.getName());
        deliveryAddress.setSurname(purchaseBody.getSurname());
        deliveryAddress.setEmail(purchaseBody.getEmail());
        deliveryAddress.setCity(city);
        deliveryAddress.setZipCode(purchaseBody.getZipCode());
        deliveryAddress.setAddressLine(purchaseBody.getAddressLine());

        deliveryAddressRepository.save(deliveryAddress);

        Purchase purchase = new Purchase();
        purchase.setCreatedAt(new Date());
        purchase.setDiet(diet);
        purchase.setDeliveryAddress(deliveryAddress);
        purchase.setWeeks(purchaseBody.getWeeks());
        purchase.setStatus("PENDING");

        purchaseRepository.save(purchase);

        Map<String, Long> result = new HashMap<>();
        result.put("id", purchase.getId());

        return result;
    }

    /**
     * Zabezpieczona lista zamówień
     *
     * @param userBody Dane wymagane do autentykacji
     * @return Lista złożonych zamówień
     * @throws AccessDeniedException Odmowa dostępu do danych
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/purchases")
    public List<PurchaseResponse> listAll(@RequestBody UserBody userBody) throws AccessDeniedException {
        User user = userRepository.findOneByUsername(userBody.getUsername());
        if (!user.getPassword().equals(userBody.getPassword())) {
            throw new AccessDeniedException("Not authenticated");
        }

        return purchaseRepository.findAll().stream().map(PurchaseResponse::from).collect(Collectors.toList());
    }
}
