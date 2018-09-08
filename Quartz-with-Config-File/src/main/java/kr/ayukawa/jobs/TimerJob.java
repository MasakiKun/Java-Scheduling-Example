package kr.ayukawa.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 현재 시각을 표시한다
 */
public class TimerJob implements Job {
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

		System.out.println(now.format(formatter));
	}
}
