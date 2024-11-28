package UserService.userService.repository;

import UserService.userService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByRut(String rut);
    UserEntity findByName(String name);
    UserEntity findByEmail(String email);

}
