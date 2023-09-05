package com.lcwd.user.service.service.impl;

import com.lcwd.user.service.entity.Hotel;
import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.execption.ResourceNotFoundException;
import com.lcwd.user.service.external.service.HotelService;
import com.lcwd.user.service.repositry.UserRepository;
import com.lcwd.user.service.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired

    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //create the unique id//unique id generated in string
        String randamUserId = UUID.randomUUID().toString();
        //set the user id
        user.setUserId(randamUserId);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();

        return all;
    }

    @Override
    public User getUser(String userId) {
        //we have to connect the userId of the rating to the this method
        //http of the rating UserId so otake that userId
        //http://localhost:8083/api/user/31b3b44a-68f2-420d-87b9-96cb1a04db5a this the userId from the rating userID

//get the userId from the user db
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("Resource Not Found" + userId));
        //fetch the UserId from the Rating UserId
        //http its not dynamic http://localhost:8083/api/user/31b3b44a-68f2-420d-87b9-96cb1a04db5a
     //restTemplate.getForObject("http://localhost:8083/api/user/31b3b44a-68f2-420d-87b9-96cb1a04db5a", ArrayList.class);
        //type of the data i.e in the ratinfg in the entity layer
        //iuse the logger

        //how to make the UserId Dynamic
//        ArrayList<Rating> ratingsOfUser =restTemplate.getForObject
//                ("http://localhost:8083/api/user/"+user.getUserId(), ArrayList.class);
        //the above one only for getting the rating and its store in the for of
        // linkedhashmap so if i want to get the hotel id also means get the exception
        //java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to com.lcwd.user.service.entity
        // so in order to resolve this we have to convert the arrayList int Rating[]
       Rating[] ratingsOfUser =restTemplate.getForObject
                ("http://RATING-SERVICE/api/user/"+user.getUserId(), Rating[].class);

        logger.info("{} ",ratingsOfUser);
        //conversion Arrays to List
        List<Rating> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());


        //for the fetching the hotel Details
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //here for every rating the hotel is fetched so were are using like this
            //call the api of hotelId
            //http://localhost:8082/api/0a313d53-c75e-4eb0-99ae-501e26e98d27
            //use the fiegnclient so comments this
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(
//                    "http://HOTEL-SERVICE/api/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //comment this also
            //logger.info("reponse status code: {} ",forEntity.getStatusCode());
            //set the hotel to rating

            rating.setHotel(hotel);
            //return the rating

            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);
        return user;
    }
}
