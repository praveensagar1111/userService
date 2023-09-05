package com.lcwd.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="NAME",length = 20)
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ABOUT")
    private String about;
    //to the rating from the particular user so we have to connect
    //transient because we are not creating the db for the atring we have to create t
    //the new  microservice rating so
    //this filed is ignored by the tranisent
    //array list i.e is blank
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
