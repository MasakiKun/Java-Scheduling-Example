package kr.ayukawa.config;

import kr.ayukawa.jobs.TimerJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Calendar;
import java.util.Date;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setTaskScheduler(this.scheduler());

		// 정해진 주기로 Task를 실행한다
		// 이 외에도 addFixedDelayTask나 addCronTask 등의 메서드를 사용할 수 있다
		// 만약 좀 더 복잡한 주기로 실행해야 하는 경우라면, 실행 주기에 Trigger를 이용하는
		// dynamicConfigureTasks 메서드를 참고한다
		taskRegistrar.addFixedRateTask(
			new IntervalTask(
				() -> this.timerJob().execute(),
				1000,
				3000
			)
		);
	}

	@Bean
	public TaskScheduler scheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("scheduler-thread-");
		scheduler.setPoolSize(2);
		return scheduler;
	}

	@Bean
	public TimerJob timerJob() {
		return new kr.ayukawa.jobs.TimerJob();
	}

	public void dynamicConfigureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setTaskScheduler(this.scheduler());
		taskRegistrar.addTriggerTask(
			() -> this.timerJob().execute(),
			new SchedulerConfig.CustomTrigger()
		);
	}

	private static class CustomTrigger implements Trigger {
		@Override
		public Date nextExecutionTime(TriggerContext context) {
			Calendar calendar = Calendar.getInstance();
			Date nextDate = calendar.getTime();

			int second = nextDate.getSeconds();
			nextDate.setSeconds(second + 1);

			return nextDate;
		}
	}
}

