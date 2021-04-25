package com.demo.controller;

import com.demo.model.UserDto;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    //can use to get all data in users table
//    @RequestMapping("get-users")
//    public ResponseEntity<List<UserDto>> getUsers() {
//        return ResponseEntity.ok(userService.getAll());
//    }

    @GetMapping("{username}")
    public  ResponseEntity<String> getUserByUsername(@PathVariable String username) {
        if(userService.getUserByUsername(username) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(String.format("User with username " + username +" does not exists."));
        }
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok(userService.delete());
    }

    @PutMapping("update-password")
    public ResponseEntity<String> updatePassword(@RequestBody String password) {
        if (password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please add new password.");
        }
        return ResponseEntity.ok(userService.updatePassword(password));
    }

}
