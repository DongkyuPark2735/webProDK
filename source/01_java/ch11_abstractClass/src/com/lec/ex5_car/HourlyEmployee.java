package com.lec.ex5_car;

public class HourlyEmployee extends Employee{
	private int hoursWorked;
	private int monetPerHour;
	
	
	
	public HourlyEmployee(String name, int hoursWorked, int monetPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.monetPerHour = monetPerHour;
	}

	@Override
	public int computePay() {
		return hoursWorked*monetPerHour;
	}
	
	
}

