package com.lec.ex3_set;

public class Student {
	private int grade;
	private String name;

	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}

	public String toString() {
		return grade + "�г� " + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof String) {
//			boolean gradeChk = grade == ((Student) obj).grade;
//			boolean nameChk = name.equals(((Student) obj).name);
//			return gradeChk && nameChk;
			
			return toString().equals(obj.toString());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

}
