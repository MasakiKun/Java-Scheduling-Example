package kr.ayukawa.quartz;

import kr.ayukawa.jobs.TimerJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class EntryPoint {
	public static void main(String[] args) {
		System.out.println("현재시각: " + LocalDateTime.now().toString());
		System.out.println("3초 후 시각 표시 시작");

		// 실행할 Job 지정
		JobDetail timerJob = newJob(TimerJob.class)
				.withIdentity("timerJob")
				.build();

		// Job을 실행할 Trigger 설정
		Date after3sec = Date.from(
				LocalDateTime.now().plusSeconds(3).atZone(ZoneId.systemDefault()).toInstant());
		Trigger timerJobTrigger = newTrigger()
				.withIdentity("timerJobTrigger")
				.startAt(after3sec)
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.build();

		Scheduler scheduler;

		try {
			// 스케줄러 작성
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 스케줄링할 Job과 Trigger 지정
			scheduler.scheduleJob(timerJob, timerJobTrigger);
			scheduler.start();
		} catch(SchedulerException e) {
			e.printStackTrace();
		}
	}
}
