package pl.czart.usersCrud.service;


import org.springframework.web.client.RestTemplate;
import pl.czart.usersCrud.external.dto.Cars;


public class RestTemplateService {
    private final RestTemplate restTemplate;

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Cars getCars() {
        String url = "http://localhost:8090/cars";
        Cars cars = restTemplate.getForObject(url, Cars.class);
        return cars;
    }
}
