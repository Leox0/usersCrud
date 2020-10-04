package pl.czart.usersCrud.dto;

import lombok.Builder;
import lombok.Value;
import pl.czart.usersCrud.external.dto.CarDto;

import java.util.List;

@Value
@Builder
public class UserViewWithCars {

    private String name;

    private String surname;

    private int age;

    private List<CarDto> carList;
}
