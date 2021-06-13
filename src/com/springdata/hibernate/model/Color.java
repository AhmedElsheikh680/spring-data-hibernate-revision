package com.springdata.hibernate.model;

import java.util.ArrayList;
import java.util.List;

public class Color {
	
	private int id;
	
	private String name;
	
	private List<Car> cars = new ArrayList<>();

	public Color() {
		super();
	}

	public Color(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	

}
