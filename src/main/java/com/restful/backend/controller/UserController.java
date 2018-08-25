package com.restful.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restful.backend.database.UserDatabase;
import com.restful.backend.exception.ResourceNotFoundException;
import com.restful.backend.model.User;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlador de usuarios
 * @author Agustín Dye
 */

@RestController
public class UserController {

    @Autowired
    UserDatabase userRepository;

    // Get All Users
    @GetMapping("/usuarios")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


 // Create a new User
    @RequestMapping(value="/usuarios", method=RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }


 // Get a Single User
    @GetMapping("/usuarios/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }


 // Update a User
    @PutMapping("/usuarios/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                                            @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDetails.getName());
        user.setSurname(userDetails.getSurname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user);
        
    }


    // Delete a User
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
