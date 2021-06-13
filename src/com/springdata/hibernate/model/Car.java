package com.springdata.hibernate.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	private int id;
	
	private String name;
	
	private List<Color> colors = new ArrayList<>();

	public Car() {
		super();
	}

	public Car(String name) {
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

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
	
	
	

}
