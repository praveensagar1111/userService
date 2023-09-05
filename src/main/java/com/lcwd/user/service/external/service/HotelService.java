package com.lcwd.user.service.external.service;

import com.lcwd.user.service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
//what is FeignClient
//The feign is a declarative HTTP web cliennt developed by NetFlix
//how to create
//create the interface and @Annotation
public interface HotelService {
    @GetMapping("/api/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
