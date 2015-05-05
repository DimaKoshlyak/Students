package com.students;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerHTTP {
	
	static List<Student> group = new ArrayList<>();
	
	public ServerHTTP(List<Student> group) {
		super();
		this.group = group;
	}

	public static void serverRun() {
		String answer = "";

		answer += "<html><head><title>Student</title> <meta charset='utf-8'></head><body><p>Список студентов группы: "
				+ "KSM-141" + "</p><br>";
		answer += "<table border='2' cellpadding='5' ><tr><th>Фамилия</th><th>Имя</th><th>Курс</th></tr>";

		for (int i = 0; i < group.size(); i++) {
			Student st = group.get(i);
			answer += "<tr>";
			answer += "<td>" + st.getName() + "</td>";
			answer += "<td>" + st.getSex() + "</td>";
			answer += "<td>" + st.getAge() + "</td>";
			answer += "</tr>";
		}
		answer += "</table></body></html>";
		try (ServerSocket soc = new ServerSocket(8002)) {
			for (;;) {
				Socket clisoc = soc.accept();
				Client cli = new Client(clisoc, answer);
			}
		} catch (IOException e) {
			System.out.println(e);
			System.out.println("Error to server Socket Open!!!");
		}
	}
}
