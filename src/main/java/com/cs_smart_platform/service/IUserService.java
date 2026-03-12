package com.cs_smart_platform.service;

import java.util.List;

import com.cs_smart_platform.dto.UserPatchRequest;
import com.cs_smart_platform.dto.UserRequest;
import com.cs_smart_platform.dto.UserResponse;

public interface IUserService {
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    UserResponse create(UserRequest request);
    UserResponse update(Long id, UserRequest request);
    void deleteById(Long id);
    UserResponse patchUpdate(Long id, UserPatchRequest request);
}
