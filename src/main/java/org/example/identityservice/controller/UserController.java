package org.example.identityservice.controller;

import jakarta.validation.Valid;
import org.example.identityservice.dto.request.UserCreationRequest;
import org.example.identityservice.dto.request.UserUpdateRequest;
import org.example.identityservice.entity.User;
import org.example.identityservice.service.Userserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private Userserviceimpl userService;

    @PostMapping
    public User createUser(@RequestBody @Valid  UserCreationRequest request) {
        return userService.createRequest(request);
    }
    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    User updateUser(@PathVariable Long userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }


}
