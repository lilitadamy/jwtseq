package com.demo.service;

import com.demo.model.UserDto;

import java.util.List;


public interface UserService {
    public String getUserByUsername(String username);
    public String updatePassword(String password);
    public List<UserDto> getAll();
    public String delete();
    public String getCurrentUsername();


}
