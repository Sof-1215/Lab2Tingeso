package UserService.userService.controller;

import UserService.userService.entity.UserEntity;
import UserService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> listUsers() {
        List<UserEntity> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("login/{rut}")
    public ResponseEntity<UserEntity> login(@PathVariable String rut) {
        UserEntity user = userService.getUserByRut(rut);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        UserEntity userNew = userService.saveUser(user);
        return ResponseEntity.ok(userNew);
    }

    @PutMapping("/")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        UserEntity userUpdated = userService.updateUser(user);
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id) throws Exception{
        var isDeleted = userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
