package com.sperandio.poc.microservice.rentcarcomposite.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CarVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String model;
	private String color;
	private Integer yearOfMade;
	private Double price;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getYearOfMade() {
		return yearOfMade;
	}
	public void setYearOfMade(Integer yearOfMade) {
		this.yearOfMade = yearOfMade;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [id= " + this.id + ", model= " + this.model + ", color= " + this.color + ", yearOfMade= " + this.yearOfMade + ", price= " + this.price + "].";
	}
}
