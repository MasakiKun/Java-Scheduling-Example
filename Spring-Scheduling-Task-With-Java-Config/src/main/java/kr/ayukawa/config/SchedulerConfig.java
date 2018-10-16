package kr.ayukawa.config;

import kr.ayukawa.jobs.TimerJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class SchedulerConfig {
	@Bean
	public TaskScheduler scheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("scheduler-thread-");
		scheduler.setPoolSize(2);
		return scheduler;
	}

	@Bean
	public TimerJob timerJob() {
		return new TimerJob();
	}

	@Scheduled(fixedRate=1000, initialDelay=3000)
	public void executeTask() {
		this.timerJob().execute();
	}
}
