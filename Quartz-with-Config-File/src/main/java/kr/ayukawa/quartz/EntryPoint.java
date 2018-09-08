package kr.ayukawa.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;

public class EntryPoint {
	public static void main(String[] args) {
		System.out.println("현재시각: " + LocalDateTime.now().toString());
		System.out.println("현재 시각 표시 시작");

		Scheduler scheduler;

		try {
			scheduler = new StdSchedulerFactory("quartz.properties").getScheduler();
			scheduler.start();
		} catch(SchedulerException e) {
			e.printStackTrace();
		}
	}
}
