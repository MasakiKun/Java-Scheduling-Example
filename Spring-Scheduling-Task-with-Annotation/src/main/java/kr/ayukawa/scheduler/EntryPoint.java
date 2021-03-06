package kr.ayukawa.scheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class EntryPoint {
	public static void main(String[] args) {
		System.out.println("현재시각: " + LocalDateTime.now().toString());
		System.out.println("3초 후 시각 표시 시작");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	}
}
