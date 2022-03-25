package strategy3.modul;

import strategy3.GetStudentPay;
import strategy3.JobStudy;

public class Student extends Person {

	private String ban;
	
	
	public Student() {
		super();
	}
	
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}


	@Override
	public void print() {
		System.out.println("ID : " + getId() + "\t이름 : " + getName() + "\t구분 : " + ban);
	}
	@Override
	public String toString() {
		return super.getId() + " "+ super.getName()+ " " + ban;
	}


	
}
