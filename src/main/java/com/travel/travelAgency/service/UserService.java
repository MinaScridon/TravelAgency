package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.UserDto;
import com.travel.travelAgency.entities.User;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> findAllContinents() {
        return userRepo.findAll().stream().map(user -> userMapper
                .convertToDto(user)).collect(Collectors.toList());
    }

    public Optional<UserDto> findByName(String name) {
        User user = userRepo.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("User with the name " + name + " not found"));
        return Optional.ofNullable(userMapper.convertToDto(user));
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.convertToEntity(userDto);
        userRepo.save(user);
        return userMapper.convertToDto(user);
    }

    public UserDto editUser(String name, UserDto userDto) {
        User user = userRepo
                .findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("User with the name " + name + " not found"));
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);

        return userMapper.convertToDto(user);
    }

    public void deleteUser(String name){
        User user = userRepo
                .findByName(name)
                .orElseThrow(()->new ResourceNotFoundException("User with the name " + name + " not found"));
        userRepo.delete(user);
    }
}
