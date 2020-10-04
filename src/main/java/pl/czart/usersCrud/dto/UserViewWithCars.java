package pl.czart.usersCrud.dto;

import lombok.Builder;
import lombok.Value;
import pl.czart.usersCrud.external.dto.CarList;

@Value
@Builder
public class UserViewWithCars {

    private String name;

    private String surname;

    private int age;

    private CarList carList;
}
