package com.sperandio.poc.microservice.rentcarcomposite.service;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sperandio.poc.microservice.rentcarcomposite.model.CarVO;

public interface CarService {

	final static String PREFIX = "api/";

	@RequestMapping(value = PREFIX + "cars", method=RequestMethod.GET)
    List<CarVO> getCards();
     
    @RequestMapping(value = PREFIX + "car/{carId}", method=RequestMethod.GET)
    CarVO getCar(@PathVariable("carId") Long carId);
     
    @RequestMapping(value= PREFIX + "new-car", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) //it could be PUT
    void createCar(@RequestBody CarVO card);
}
