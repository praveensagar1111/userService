package com.lcwd.user.service.repositry;

import com.lcwd.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    //if you want to implement any custom method or query
    //write
}
