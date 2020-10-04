package pl.czart.usersCrud.external;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.czart.usersCrud.external.dto.CarList;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    private final String carsUrl = "http://localhost:8090/cars";

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CarList getCars() {
        CarList carList = restTemplate.getForObject(carsUrl, CarList.class);
        return carList;
    }

    public CarList getCarsByUserId(Long id) {
        String url = carsUrl + id;
        CarList carList = restTemplate.getForObject(url, CarList.class);
        return carList;
    }
}
