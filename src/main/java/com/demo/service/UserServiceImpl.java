package com.demo.service;

import com.demo.repository.UserRepository;
import com.demo.model.User;
import com.demo.model.UserDto;
import com.demo.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper = new UserMapper();

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public String getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return String.format(user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public String updatePassword(String password) {
        User user = userRepository.findByUsername(this.getCurrentUsername());
        user.setPassword(bcryptEncoder.encode(password));
        return String.format(user.getFirstName() + " you have updated your password!" );
    }

    @Override
    public List<UserDto> getAll() {
        return userMapper.mapListUserToUserDto(userRepository.findAll());
    }

    @Override
    public String delete() {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        return String.format(username + " Bye-bye!");
    }

    @Override
    public String getCurrentUsername() {
        return ((org.springframework.security.core.userdetails.User)
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal())
                .getUsername();
    }


}
