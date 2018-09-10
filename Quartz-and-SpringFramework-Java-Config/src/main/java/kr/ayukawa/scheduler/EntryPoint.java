package kr.ayukawa.scheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

// ref. https://www.concretepage.com/spring-4/spring-4-quartz-2-scheduler-integration-annotation-example-using-javaconfig
public class EntryPoint {
	public static void main(String[] args) {
		System.out.println("현재시각: " + LocalDateTime.now().toString());
		System.out.println("3초 후 시각 표시 시작");

		ApplicationContext ctx = new AnnotationConfigApplicationContext(kr.ayukawa.config.SpringConfig.class);
	}
}
