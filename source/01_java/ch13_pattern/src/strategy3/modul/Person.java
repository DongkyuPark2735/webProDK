package strategy3.modul;

import strategy3.IGet;
import strategy3.IJob;

public abstract class Person {

	private String id;
	private String name;
	private IJob job;
	private IGet get;
	//privat IJob 
	
	public Person() {
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void job() {
		job.job();
	}

	public void pay() {
		get.get();
	}

	public abstract void print();
	//print()�ۼ��ϰ� ����Ŭ�������� super.
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IJob getJob() {
		return job;
	}

	public void setJob(IJob job) {
		this.job = job;
	}

	public IGet getGet() {
		return get;
	}

	public void setGet(IGet get) {
		this.get = get;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
