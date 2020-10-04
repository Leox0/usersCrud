package pl.czart.usersCrud.service;


import org.springframework.web.client.RestTemplate;
import pl.czart.usersCrud.external.dto.Cars;


public class RestTemplateService {

    private final RestTemplate restTemplate;

    private final String carsUrl = "http://localhost:8090/cars";

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Cars getCars() {
        Cars cars = restTemplate.getForObject(carsUrl, Cars.class);
        return cars;
    }

    public Cars getCarsByUserId(Long id) {
        String url = carsUrl + id;
        Cars cars = restTemplate.getForObject(url, Cars.class);
        return cars;
    }
}
