package pl.czart.usersCrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czart.usersCrud.dto.UserRequest;
import pl.czart.usersCrud.dto.UserView;
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
    public ResponseEntity<List<UserView>> getAllUsers() {
        List<UserView> allUsers = userService.getAllUsers();
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

    @GetMapping("/{id}")
    public ResponseEntity<UserView> getUserById(@RequestParam Long id){
        UserView userById = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userById);
    }

}
