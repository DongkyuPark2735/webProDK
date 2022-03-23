package com.lec.ex5_car;

import java.lang.annotation.Retention;

import com.lec.cons.Constant;

public class SalaryEmployee extends Employee {
	private int annalSalary;

	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public int computePay() {
		return (this.annalSalary / 14);
	}

}
