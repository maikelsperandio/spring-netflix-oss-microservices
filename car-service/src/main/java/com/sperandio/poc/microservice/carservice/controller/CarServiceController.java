package com.sperandio.poc.microservice.carservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sperandio.poc.microservice.carservice.model.Car;

@RestController
@RequestMapping(value="/api")
public class CarServiceController {

	private List<Car> repo;

	@PostConstruct
	public void init() {
		this.repo = new ArrayList<Car>();
		this.repo.add(new Car(1, "Chevelle", "Red", 1972, 98.9));
		this.repo.add(new Car(2, "Impala", "Black", 1969, 108.9));
		this.repo.add(new Car(3, "Barracuda", "Yellow/Black", 1971, 128.9));
		this.repo.add(new Car(4, "Charger", "Orange", 1972, 95.9));
		this.repo.add(new Car(5, "Camaro", "Blue", 1969, 148.9));
	}

	@RequestMapping(value="/cars", method=RequestMethod.GET)
	public List<Car> getCars(){
		return this.repo;
	}

	@RequestMapping(value="/car/{carId}", method=RequestMethod.GET)
	public Car getCar(@PathVariable Long carId) {
		return Optional.ofNullable(this.repo.stream().filter((car) -> car.getId().equals(carId)).reduce(null, (u, v) -> {
            if (u != null && v != null)
		                throw new IllegalStateException("More than one CarId found");
		            else return u == null ? v : u;
		        })).get();
	}

	@RequestMapping(value = "/new-card", method = RequestMethod.POST, headers = "Accept=application/json")
    public void createCar(@RequestBody Car newCar) {
        if(newCar.getId()!=null){
            this.repo.add(newCar);
        }
        System.out.println("New card passing: " + newCar);
    }
}
