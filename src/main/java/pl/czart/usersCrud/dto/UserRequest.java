package pl.czart.usersCrud.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String name;

    private String surname;

    private int age;

}
