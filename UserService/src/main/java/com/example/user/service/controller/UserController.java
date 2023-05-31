package com.example.user.service.controller;


import com.example.user.service.enitities.User;
import com.example.user.service.services.UserServices;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        User newUser=this.userServices.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser=this.userServices.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }
   @GetMapping("/{userId}")
   public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
       User user=this.userServices.getUserById(userId);
       return new ResponseEntity<>(user,HttpStatus.OK);
   }
    @PutMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId,@RequestBody User user){
        User u=this.userServices.updateUserById(userId,user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        this.userServices.deleteUserById(userId);
    }
}
