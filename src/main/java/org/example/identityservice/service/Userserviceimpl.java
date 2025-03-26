package org.example.identityservice.service;

import lombok.RequiredArgsConstructor;
import org.example.identityservice.dto.request.UserCreationRequest;
import org.example.identityservice.dto.request.UserUpdateRequest;
import org.example.identityservice.entity.User;
import org.example.identityservice.mapper.UserMapper;
import org.example.identityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userserviceimpl implements Userservice {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User createRequest(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already exists");
        }
        User user = userMapper.toUser(request);
        return userRepository.save(user);
    }
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    @Override
    public User updateUser(Long userId , UserUpdateRequest request) {
        User user = getUser(userId);
        userMapper.updateUser(user,request);
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
