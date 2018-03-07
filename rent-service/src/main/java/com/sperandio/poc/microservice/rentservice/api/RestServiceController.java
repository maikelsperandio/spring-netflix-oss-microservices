package com.sperandio.poc.microservice.rentservice.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sperandio.poc.microservice.rentservice.model.Rent;

@RestController
@RequestMapping(value="/api")
public class RestServiceController {

	private List<Rent> repo;

	@PostConstruct
	public void init() {
		this.repo = new ArrayList<Rent>();
		this.repo.add(new Rent(1, 3, 258.9, new Date()));
		this.repo.add(new Rent(2, 5, 95.9, new Date()));
		this.repo.add(new Rent(3, 2, 200.9, new Date()));
		this.repo.add(new Rent(4, 3, 358.9, new Date()));
	}

	@RequestMapping(value="/rents", method=RequestMethod.GET)
	public List<Rent> getRents(){
		return this.repo;
	}

	@RequestMapping(value="/rent/{rentId}", method = RequestMethod.GET)
    public Rent getStatament(@PathVariable Integer rentId) {
        return Optional.ofNullable(
                this.repo
                .stream()
                .filter((rent) -> rent.getId().equals(rentId))
                .reduce(null, (u, v) -> {
                    if (u != null && v != null)
                        throw new IllegalStateException("More than one rentId found");
                    else return u == null ? v : u;
                })).get();
    }

	@RequestMapping(value="/rent", method = RequestMethod.GET)
    public List<Rent> getStatements(@RequestParam Integer carId){
        if(carId!=null){
            return this.repo
                    .stream()
                    .filter((rent) -> rent.getCarId().equals(carId))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
