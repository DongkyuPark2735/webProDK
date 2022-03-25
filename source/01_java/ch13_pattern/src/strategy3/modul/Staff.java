package strategy3.modul;

import strategy3.GetSalary;
import strategy3.JobMng;

public class Staff extends Person {

	private String part;

	public Staff() {
	}

	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	@Override
	public String toString() {
		return super.getId() + " "+ super.getName()+ " " + part;
	}
	

	@Override
	public void print() {
		System.out.println("ID : " + getId() + "\t이름 : " + getName() + "\t구분 : " + part);
	}

}
