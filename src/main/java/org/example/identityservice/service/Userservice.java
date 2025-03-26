package org.example.identityservice.service;

import org.example.identityservice.dto.request.UserCreationRequest;
import org.example.identityservice.dto.request.UserUpdateRequest;
import org.example.identityservice.entity.User;

import java.util.List;

public interface Userservice {
    User createRequest(UserCreationRequest request);
    List<User> getUsers();
    User updateUser(Long userId , UserUpdateRequest request);
    void deleteUser(Long userId);
}
