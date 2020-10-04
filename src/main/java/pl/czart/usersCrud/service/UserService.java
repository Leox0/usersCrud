package pl.czart.usersCrud.service;

import org.springframework.stereotype.Service;
import pl.czart.usersCrud.dto.UserRequest;
import pl.czart.usersCrud.dto.UserViewWithCars;
import pl.czart.usersCrud.dto.UserViewWithoutCars;
import pl.czart.usersCrud.entity.User;
import pl.czart.usersCrud.exception.UserNotFoundException;
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

    public List<UserViewWithoutCars> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(User::toViewWithoutCar)
                .collect(Collectors.toList());
    }

    public UserViewWithCars getUserWithCarsById(Long id){
        User user = getUserIfExistsOrThrowException(id);
        return user.toViewWithCar();
    }

    public UserViewWithoutCars getUserWithoutCarsById(Long id){
        User user = getUserIfExistsOrThrowException(id);
        return user.toViewWithoutCar();
    }

    private User getUserIfExistsOrThrowException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User for given id not exists"));
    }
}
