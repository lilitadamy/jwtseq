package com.demo.model;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    ModelMapper modelMapper = new ModelMapper();

    public UserDto mapUserToUserDto (User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public User mapUserDtoToUser (UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    public List<UserDto> mapListUserToUserDto (List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users) {
            userDtos.add(mapUserToUserDto(user));
        }
        return userDtos;
    }
}
