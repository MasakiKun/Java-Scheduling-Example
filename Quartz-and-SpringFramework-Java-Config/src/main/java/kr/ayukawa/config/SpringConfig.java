package kr.ayukawa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class SpringConfig {

	@Bean
	public JobDetailFactoryBean TimerJob() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(kr.ayukawa.jobs.TimerJob.class);
		factory.setBeanName("timerJob");
		factory.setDescription("1초 타이머");
		factory.setDurability(true);
		return factory;
	}

	@Bean
	public SimpleTriggerFactoryBean TimerJobTrigger() {
		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
		factory.setJobDetail(this.TimerJob().getObject());
		factory.setStartDelay(3000);
		factory.setRepeatInterval(1000);
		return factory;
	}

	@Bean
	public SchedulerFactoryBean QuartzScheduler() {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setAutoStartup(true);
		factory.setTriggers(this.TimerJobTrigger().getObject());
		return factory;
	}
}
