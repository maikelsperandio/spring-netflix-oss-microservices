package com.sperandio.poc.microservice.rentcarcomposite.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sperandio.poc.microservice.rentcarcomposite.model.CarVO;
import com.sperandio.poc.microservice.rentcarcomposite.model.RentVO;
import com.sperandio.poc.microservice.rentcarcomposite.service.CarClient;
import com.sperandio.poc.microservice.rentcarcomposite.service.RentClient;

@RestController
@RequestMapping(value="/api")
public class CarRentController {

	@Autowired
	CarClient carClient;

	@Autowired
	RentClient rentClient;

	private List<RentVO> repo;

	@PostConstruct
	public void init() {
		this.repo = new ArrayList<RentVO>();
		this.repo.add(new RentVO(1, 3, 258.9, new Date()));
		this.repo.add(new RentVO(2, 5, 95.9, new Date()));
		this.repo.add(new RentVO(3, 2, 200.9, new Date()));
		this.repo.add(new RentVO(4, 3, 358.9, new Date()));
	}

	@RequestMapping(value="/rents", method=RequestMethod.GET)
	public List<RentVO> getRents(){
		return this.repo;
	}	 

	@RequestMapping(value="/rent-by-car", method=RequestMethod.GET)
    public ResponseEntity<Map<CarVO, List<RentVO>>> getRentByCarId(@RequestParam Long carId){
        Map<CarVO, List<RentVO>> response = new HashMap<>();
         
        response.put(carClient.getCar(carId), rentClient.getRents(carId));
         
        return new ResponseEntity<Map<CarVO,List<RentVO>>>(response, HttpStatus.OK);
    }
}
