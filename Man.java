package com.students;

public class Man {
	private int age;
	private String name;
	private String sex;
	public Man(int age, String name, String sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
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
	
	public void getInfo(){
		System.out.println("Name =" + name);
		System.out.println("Age = " + age);
		System.out.println("Sex = " + sex);
		System.out.println("----------------------");
	}
	
}
