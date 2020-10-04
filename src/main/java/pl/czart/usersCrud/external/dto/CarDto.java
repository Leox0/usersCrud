package pl.czart.usersCrud.external.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarDto {

    private Long id;

    private String brand;

    private String model;

    private String year;

}
