package pl.czart.usersCrud.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserViewWithoutCars {

    private String name;

    private String surname;

    private int age;
}

