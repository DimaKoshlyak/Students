package com.students;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.interf.test.Bug;

public class Group{

	private Student[] group = new Student[10];
	

	public void run(){
	File foldername= new File("student.txt");
	int option;
	
	System.out
			.println("Choose the type of students' input. 1 - manual, 2 - use the defualt info");
	option = Integer.valueOf(Group.input(""));
	switch (option) {

	case 1:{
		studentsInput();
		break;
	}
	case 2: {
		group[0] = new Student(18, "Pavlov Anton", "male");
		group[1] = new Student(20, "Pavlov Sergey", "male");
		group[2] = new Student(17, "Ivanova Mariya", "female");
		group[3] = new Student(22, "Ivanov Ivan", "male");
		group[4] = new Student(19, "Aleksandrova Anastasiya", "female");
		group[5] = new Student(18, "Aleksandrov Artem", "male");
		group[6] = new Student(27, "Shrayk Roman", "male");
		group[7] = new Student(35, "Lyashko Oleg", "male");
		group[8] = new Student(21, "Lyuksemburg Roza", "female");
		group[9] = new Student(24, "Borisova Lesya", "female");
		break;
	}
}
	writeToFile(group, foldername);

	for (Student elem : group) {
		elem.getInfo();
	}
	
	System.out.println("\n\n Reading from file.... \n");
	readFromFile(group, foldername);
}
	
public void output(){
	System.out.println("*************Sorted group**************");
	Arrays.sort(group);
	for (Student elem : group) {
		elem.getInfo();
	}
}

public void studentsInput() {
	System.out.println("Please enter the information about students:");
	for (int i = 0; i < group.length; i++) {
		System.out.println((i + 1) + " student --------->");
		String name = input("Enter student name: ");
		int age = Integer.valueOf(input("Enter student age: "));
		String sex = input("Enter student sex: ");
		try {
			group[i] = new Student(age, name, sex);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of bounds!");
		}
		System.out.println("---------------------");
	}
}

static void writeToFile(Student[] group, File folderName){
	try(BufferedWriter bw = new BufferedWriter(new FileWriter(folderName))){
		if(!folderName.exists()){
			folderName.createNewFile();
		}
		for(Student elem:group){
			bw.write("Student: " + elem.getName());
			bw.newLine();
			bw.write("Age : " + elem.getAge());
			bw.newLine();
			bw.write("Sex: " + elem.getSex());
			bw.newLine();
			bw.write("-------------------------");
			bw.newLine();
		}
	}catch(IOException e){
		System.out.println("Error!");
	}
}

static void readFromFile(Student[] group,File foldername){
	try(BufferedReader br = new BufferedReader(new FileReader(foldername))){
		String str = "";
		for (;(str = br.readLine())!=null;){
			System.out.println(str); 
		}
	}catch(IOException e){
		System.out.println("Error!");
}
}

public static String input(String message) {
	System.out.print(message + ": ");
	Scanner scan = new Scanner(System.in);
	return scan.next();
}
}

	


