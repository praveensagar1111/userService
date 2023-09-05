package com.lcwd.user.service;

import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
private RatingService ratingService;
	@Test
		void  createRating(){
		Rating thisIsTesting = Rating.builder().rating(10).userId("").hotelId("").feedback("this is testing").build();
		Rating rating = ratingService.createRating(thisIsTesting);

System.out.println("created");
	}



}
