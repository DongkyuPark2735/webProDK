package strategy3.modul;

import strategy3.GetSalary;
import strategy3.JobLec;

public class Lecturer extends Person {

	private String subString;

	public Lecturer() {
		super();
	}

	public Lecturer(String id, String name, String subString) {
		super(id, name);
		this.subString = subString;
		setJob(new JobLec());
		setGet(new GetSalary());
	}

	@Override
	public void print() {
		System.out.println("ID : " + getId() + "\t이름 : " + getName() + "\t구분 : " + subString);
	}
	@Override
	public String toString() {
		return super.getId() + " "+ super.getName()+ " " + subString;
	}

}
