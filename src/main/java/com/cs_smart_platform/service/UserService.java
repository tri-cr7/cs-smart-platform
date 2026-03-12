package com.cs_smart_platform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs_smart_platform.dto.UserPatchRequest;
import com.cs_smart_platform.dto.UserRequest;
import com.cs_smart_platform.dto.UserResponse;
import com.cs_smart_platform.exceptions.ResourceNotFoundException;
import com.cs_smart_platform.model.User;
import com.cs_smart_platform.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(UserResponse::fromEntity)
                .toList();
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return UserResponse.fromEntity(user);
    }

    @Override
    public UserResponse create(UserRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setFullName(request.fullName());
        return UserResponse.fromEntity(userRepository.save(user));
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setFullName(request.fullName() != null ? request.fullName() : user.getFullName());
        return UserResponse.fromEntity(userRepository.save(user));
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id))
            throw new ResourceNotFoundException("User", "id", id);
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse patchUpdate(Long id, UserPatchRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setUsername(request.username() != null ? request.username() : user.getUsername());
        user.setEmail(request.email() != null ? request.email() : user.getEmail());
        user.setFullName(request.fullName() != null ? request.fullName() : user.getFullName());
        return UserResponse.fromEntity(userRepository.save(user));
    }
}
