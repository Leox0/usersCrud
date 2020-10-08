package pl.czart.usersCrud.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.czart.usersCrud.dto.UserViewWithCars;
import pl.czart.usersCrud.dto.UserViewWithoutCars;
import pl.czart.usersCrud.external.dto.CarDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private int age;


    public UserViewWithCars toViewWithCar(List<CarDto> carDtoList) {
        return UserViewWithCars.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .carList(carDtoList)
                .build();
    }

    public UserViewWithoutCars toViewWithoutCar() {
        return UserViewWithoutCars.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .build();
    }


}
