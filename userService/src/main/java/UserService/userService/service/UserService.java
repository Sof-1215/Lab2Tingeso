package UserService.userService.service;

import UserService.userService.entity.UserEntity;
import UserService.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserEntity> getUsers(){
        return (ArrayList<UserEntity>) userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public UserEntity getUserByRut(String rut){
        return userRepository.findByRut(rut);
    }

    public UserEntity updateUser(UserEntity user){
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) throws Exception{
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}