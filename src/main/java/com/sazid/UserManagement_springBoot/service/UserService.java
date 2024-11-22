package com.sazid.UserManagement_springBoot.service;

import com.sazid.UserManagement_springBoot.dto.UserDto;
import com.sazid.UserManagement_springBoot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    User getUserById(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long userId);
}
