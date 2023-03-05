package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.UserDto;
import com.travel.travelAgency.entities.User;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserMapper implements Mapper<User, UserDto> {
    public List<UserDto> listConvertToDto(List<User> entity){
        List<UserDto> result= new ArrayList<>();
        for (User user:entity) {
            UserDto userDto = convertToDto(user);
            result.add(userDto);
        }
        return result;
    }
    public List<User> listConvertToEntity(List<UserDto> dto){
        List<User> result= new ArrayList<>();
        for (UserDto userDto:dto) {
            User convertEntity = convertToEntity(userDto);
            result.add(convertEntity);
        }
        return result;
    }
    @Override
    public UserDto convertToDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setName(entity.getName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        userDto.setPassword(entity.getPassword());
        return userDto;
    }

    @Override
    public User convertToEntity(UserDto dto) {
        User userEntity = new User();
        userEntity.setId(dto.getId());
        userEntity.setName(dto.getName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
        return userEntity;
    }
}
