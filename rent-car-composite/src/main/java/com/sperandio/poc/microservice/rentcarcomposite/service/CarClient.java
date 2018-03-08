package com.sperandio.poc.microservice.rentcarcomposite.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="car-service")
public interface CarClient extends CarService{

}
