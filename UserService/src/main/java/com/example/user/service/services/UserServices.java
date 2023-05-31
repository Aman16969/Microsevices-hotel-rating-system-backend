package com.example.user.service.services;


import com.example.user.service.enitities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    User createUser(User user);
    List<User> getAllUser();
    User getUserById(String userId);
    void deleteUserById(String userId);
    User updateUserById(String userId,User user);


}
