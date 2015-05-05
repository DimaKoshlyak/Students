package com.students;

public class Student implements Comparable {

	public Student(int age, String name, String sex) {
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

	public Student() {
		super();
	}

	int age;
	String name;
	String sex;

	public void getInfo(){
		System.out.println("Name =" + name);
		System.out.println("Age = " + age);
		System.out.println("Sex = " + sex);
		System.out.println("----------------------");
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

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
