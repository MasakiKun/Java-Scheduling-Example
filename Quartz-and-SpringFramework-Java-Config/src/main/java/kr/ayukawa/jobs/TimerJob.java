package kr.ayukawa.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 현재 시각을 표시한다
 */
public class TimerJob extends QuartzJobBean {
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

		System.out.println(now.format(formatter));
	}
}
