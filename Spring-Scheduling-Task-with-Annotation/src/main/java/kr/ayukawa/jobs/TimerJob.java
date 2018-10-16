package kr.ayukawa.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 현재 시각을 표시한다
 */
@Component
public class TimerJob {
	/*
		@Scheduled 어노테이션에 사용할 수 있는 설정은 다음과 같다.

		* fixedRate
		   * 실행 주기를 ms 단위로 지정한다. task는 fixedRate 값에 설정한 주기마다 계속 실행된다

		* fixedDelay
		   * 실행 완료 후의 딜레이를 ms 단위로 지정한다. task는 실행 후 fixedDelay만큼 대기 후 재차 실행된다

		* initialDelay
		   * 최초 실행시의 딜레이를 ms 단위로 지정한다

		* cron
		   * 실행 주기를 cron 표현식으로 지정한다
	 */
	@Scheduled(fixedRate=1000, initialDelay=3000)
	public void execute() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

		System.out.println(now.format(formatter));
	}
}
