package com.students;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Group {

	private static List<Student> groupFromFile = new ArrayList<Student>();
	static File folderName = new File("student.txt");

	public void run() {

		int option;

		System.out
				.println("Do you want to register new student? \n1 - register new student \n2 - read from file");
		option = Integer.valueOf(Group.input(""));
		switch (option) {

		case 1: {
			studentsInput();
			break;
		}
		case 2: {
			readFromFile(groupFromFile, folderName);
		}
		}
		ServerHTTP server = new ServerHTTP(groupFromFile);
		ServerHTTP.serverRun();
	}

	static void studentsInput() {
		Student temp = new Student();
		System.out.println("Please enter the information about student:");
		temp.setName(input("Enter student name: "));
		temp.setAge(Integer.valueOf(input("Enter student age: ")));
		temp.setSex(input("Enter student sex: "));
		writeToFile(temp, folderName);
	}

	static void writeToFile(Student student, File folderName) {
		System.out.println("Writing to file...");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(folderName,
				true))) {
			if (!folderName.exists()) {
				folderName.createNewFile();
			}
			bw.write("Student: " + student.getName());
			bw.newLine();
			bw.write("Age : " + student.getAge());
			bw.newLine();
			bw.write("Sex: " + student.getSex());
			bw.newLine();
			bw.write("-------------------------");
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error!");
		}
		System.out.println("Writing to file completed...");
	}

	static void readFromFile(List<Student> groupFromFile, File foldername) {
		try (BufferedReader br = new BufferedReader(new FileReader(foldername))) {
			System.out.println("\nReading from file...\n\n");
			String str = "";
			String name = "";
			int age = 0;
			String sex = "";
			String line = "";
			for (; (line = br.readLine()) != null;) {
				StringTokenizer aStringTokenizer = new StringTokenizer(line,
						" :");

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
						groupFromFile.add(new Student(age, name, sex));
						System.out.println(name + " " + age + " " + sex);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}

	public static String input(String message) {
		System.out.print(message + ": ");
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
