package pl.czart.usersCrud.service;

import org.springframework.stereotype.Service;
import pl.czart.usersCrud.dto.UserRequest;
import pl.czart.usersCrud.dto.UserView;
import pl.czart.usersCrud.entity.User;
import pl.czart.usersCrud.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .age(userRequest.getAge())
                .build();
        userRepository.save(user);
    }

    public List<UserView> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(User::toView)
                .collect(Collectors.toList());
    }
}
