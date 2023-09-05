package com.lcwd.user.service.controller;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    //create
    //http://localhost:8081/api/user
    @PostMapping("/user")
    public ResponseEntity<?> create(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
        //any one of these two
        // return  new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    //http://localhost:8081/api/1
    @GetMapping("/{userId}")//here the spelling is same so use only pathvariable
    public ResponseEntity<?> getById(@PathVariable String userId){
        User user = userService.getUser(userId);
    return ResponseEntity.ok(user);

    }
    //http://localhost:8081/api/all
    @GetMapping("/all")
    public ResponseEntity<List<User>> getall(){
        List<User> list = userService.getAllUser();
return ResponseEntity.ok(list);
    }
}
