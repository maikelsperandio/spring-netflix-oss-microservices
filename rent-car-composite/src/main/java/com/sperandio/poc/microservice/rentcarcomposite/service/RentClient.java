package com.sperandio.poc.microservice.rentcarcomposite.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="rent-service")
public interface RentClient extends RentService{

}
