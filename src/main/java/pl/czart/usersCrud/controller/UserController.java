package pl.czart.usersCrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czart.usersCrud.dto.UserRequest;
import pl.czart.usersCrud.dto.UserViewWithCars;
import pl.czart.usersCrud.dto.UserViewWithoutCars;
import pl.czart.usersCrud.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserViewWithoutCars>> getAllUsers() {
        List<UserViewWithoutCars> allUsers = userService.getAllUsers();
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(allUsers);
    }

    @PostMapping
    public ResponseEntity<Void> postUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<UserViewWithCars> getUserWithCarsById(@RequestParam Long id){
        UserViewWithCars userById = userService.getUserWithCarsById(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userById);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserViewWithoutCars> getUserWithoutCarsById(@RequestParam Long id){
        UserViewWithoutCars userById = userService.getUserWithoutCarsById(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userById);
    }

}
