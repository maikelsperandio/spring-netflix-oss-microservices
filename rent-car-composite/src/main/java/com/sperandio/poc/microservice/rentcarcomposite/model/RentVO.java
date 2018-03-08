package com.sperandio.poc.microservice.rentcarcomposite.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RentVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer carId;
	private Double rentPrice;
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Rent [ id= " + this.id + ", carId= " + this.carId + ", rentPrice= " + this.rentPrice + ", date= " + this.date + " ]";
	}
}