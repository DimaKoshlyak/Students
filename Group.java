package com.students;

import java.io.*;
import java.util.*;

public class Group {

	private Student[] group = new Student[10];
	private static List<Student> groupFromFile = new ArrayList<Student>();

	public void run() {
		File foldername = new File("student.txt");
		int option;

		System.out
				.println("Choose the type of students' input. 1 - manual, 2 - use the defualt info");
		option = Integer.valueOf(Group.input(""));
		switch (option) {

		case 1: {
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
		readFromFile(groupFromFile, foldername);
		readFromCollection();
	}

	public void output() {
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

	static void writeToFile(Student[] group, File folderName) {
		System.out.println("Writing to file...");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(folderName))) {
			if (!folderName.exists()) {
				folderName.createNewFile();
			}
			for (Student elem : group) {
				bw.write("Student: " + elem.getName());
				bw.newLine();
				bw.write("Age : " + elem.getAge());
				bw.newLine();
				bw.write("Sex: " + elem.getSex());
				bw.newLine();
				bw.write("-------------------------");
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error!");
		}
		System.out.println("Writing to file completed...");
	}

	static void readFromFile(List<Student> groupFromFile2, File foldername){
		try (BufferedReader br = new BufferedReader(new FileReader(foldername))) {
			System.out.println("\nReading from file...\n\n");
			String str = "";
			String name = "";
			int age = 0;
			String sex = "";
			String line = "";
			for (; (line = br.readLine()) != null;) {
				StringTokenizer aStringTokenizer = new StringTokenizer(line," :");

				while (aStringTokenizer.hasMoreTokens()) {

					str = aStringTokenizer.nextToken();
					if (str.equals("Student")) {
						name = aStringTokenizer.nextToken() + " "
								+ aStringTokenizer.nextToken();
					} else if (str.equals("Age")) {
						age = Integer.valueOf(aStringTokenizer.nextToken());
					} else if (str.equals("Sex")) {
						sex = aStringTokenizer.nextToken();
					} else if (str.equals("-------------------------")) {
						groupFromFile2.add(new Student(age, name, sex));
						System.out.println(name + " " + age + " " + sex);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}

	public static void readFromCollection() {
		System.out
				.println("\nReading from Collection...\n\n");
		for (int i = 0; i < groupFromFile.size(); i++) {
			Student st = groupFromFile.get(i);
			st.getInfo();
		}
	}

	public static String input(String message) {
		System.out.print(message + ": ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
}
