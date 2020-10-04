package pl.czart.usersCrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czart.usersCrud.dto.UserView;
import pl.czart.usersCrud.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRemoteController {

    private final UserService userService;

    public CarRemoteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserView>> getAllUsers() {
        List<UserView> allUsers = userService.getAllUsers();
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(allUsers);
    }

}
