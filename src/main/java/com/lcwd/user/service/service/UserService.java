package com.lcwd.user.service.service;

import com.lcwd.user.service.entity.User;

import java.util.List;

public interface UserService {

    //user operation

    //create

    User saveUser(User user);//ctr+Alt+B

    //get all user
    List<User> getAllUser();

    //get single user with userId
    User getUser(String userId);

    //todo delete
    //todo update
}
