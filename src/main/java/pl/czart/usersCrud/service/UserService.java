package pl.czart.usersCrud.service;

import org.springframework.stereotype.Service;
import pl.czart.usersCrud.dto.UserRequest;
import pl.czart.usersCrud.dto.UserViewWithCars;
import pl.czart.usersCrud.dto.UserViewWithoutCars;
import pl.czart.usersCrud.entity.User;
import pl.czart.usersCrud.exception.UserNotFoundException;
import pl.czart.usersCrud.external.RestTemplateService;
import pl.czart.usersCrud.external.dto.CarList;
import pl.czart.usersCrud.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplateService restTemplateService;

    public UserService(UserRepository userRepository, RestTemplateService restTemplateService) {
        this.userRepository = userRepository;
        this.restTemplateService = restTemplateService;
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

    public UserViewWithCars getUserWithCarsById(Long id) {
        User user = getUserIfExistsOrThrowException(id);
        CarList carListByUserId = restTemplateService.getCarsByUserId(id);
        UserViewWithCars userViewWithCars = UserViewWithCars.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .carList(carListByUserId)
                .build();
        return userViewWithCars;
    }

    public UserViewWithoutCars getUserWithoutCarsById(Long id) {
        User user = getUserIfExistsOrThrowException(id);
        return user.toViewWithoutCar();
    }

    private User getUserIfExistsOrThrowException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User for given id not exists"));
    }

}
