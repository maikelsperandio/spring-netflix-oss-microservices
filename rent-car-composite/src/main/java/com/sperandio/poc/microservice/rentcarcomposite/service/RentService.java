package com.sperandio.poc.microservice.rentcarcomposite.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sperandio.poc.microservice.rentcarcomposite.model.RentVO;

public interface RentService {

	final static String PREFIX = "api/";

	@RequestMapping(value = PREFIX + "rents", method=RequestMethod.GET)
	List<RentVO> getStatements();

	@RequestMapping(value = PREFIX + "rent/{rentId}", method=RequestMethod.GET)
	RentVO getStatament(@PathVariable("statementId") Long rentId);

    @RequestMapping(value= PREFIX + "rent", method=RequestMethod.GET)
    List<RentVO> getStatements(@RequestParam("carId") Long carId);

}
