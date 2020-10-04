package pl.czart.usersCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.czart.usersCrud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
