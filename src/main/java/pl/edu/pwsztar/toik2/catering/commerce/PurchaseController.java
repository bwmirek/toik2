package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwsztar.toik2.catering.delivery.City;
import pl.edu.pwsztar.toik2.catering.delivery.CityRepository;
import pl.edu.pwsztar.toik2.catering.delivery.DeliveryAddress;
import pl.edu.pwsztar.toik2.catering.delivery.DeliveryAddressRepository;
import pl.edu.pwsztar.toik2.catering.restaurant.Diet;
import pl.edu.pwsztar.toik2.catering.restaurant.DietRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PurchaseController {
    private final CityRepository cityRepository;
    private final DietRepository dietRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final PurchaseRepository purchaseRepository;

    @PostMapping("/purchase")
    public Map<String, Long> purchase(@RequestBody PurchaseBody purchaseBody) {
        Logger logger = LoggerFactory.getLogger(PurchaseController.class);
        logger.info(purchaseBody.toString());

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
}
