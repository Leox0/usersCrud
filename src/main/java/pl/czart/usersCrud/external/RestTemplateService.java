package pl.czart.usersCrud.external;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.czart.usersCrud.external.dto.CarDto;

import java.util.List;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    private final String carsUrl = "https://damp-gorge-76747.herokuapp.com/cars/";

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CarDto> getCars() {
        List<CarDto> carList = restTemplate.getForObject(carsUrl, List.class);
        return carList;
    }

    public List<CarDto> getCarsByUserId(Long id) {
        String url = carsUrl + id;
        List<CarDto> carList = restTemplate.getForObject(url, List.class);
        return carList;
    }
}
