package com.students;

public class Student extends Man implements Comparable {

	public Student(int age, String name, String sex) {
		super(age, name, sex);
		this.age = age;
		this.name = name;
		this.sex = sex;
		// TODO Auto-generated constructor stub
	}

	int age;
	String name;
	String sex;

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		super.getInfo();
	}

	@Override
	public int compareTo(Object st2) {
		Student b = (Student) st2;
		String str2 = b.getName();
		String str1 = name;
		if (str1.charAt(1) < str2.charAt(1))
			return 1;
		else if (str1.charAt(1) > str2.charAt(1))
			return -1;
		else
			return 0;
	}
}
