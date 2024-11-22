package com.sazid.UserManagement_springBoot.impl;

import com.sazid.UserManagement_springBoot.dto.UserDto;
import com.sazid.UserManagement_springBoot.entity.User;
import com.sazid.UserManagement_springBoot.repo.UserRepo;
import com.sazid.UserManagement_springBoot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto to user Entity
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );

        User saveUser = userRepo.save(user);

        //Convert User to UserDto

        UserDto saveUserDto = new UserDto(
                saveUser.getId(),
                saveUser.getFirstName(),
                saveUser.getLastName(),
                saveUser.getEmail()
        );
        return saveUserDto;


    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
         User previousUser = userRepo.findById(user.getId()).get();

            previousUser.setFirstName(user.getFirstName());
            previousUser.setLastName(user.getLastName());
            previousUser.setEmail(user.getEmail());

           User updateUser =  userRepo.save(previousUser);

        return updateUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
