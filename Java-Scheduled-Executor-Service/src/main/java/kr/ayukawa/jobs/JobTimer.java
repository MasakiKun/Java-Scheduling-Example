package kr.ayukawa.jobs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 현재 시각을 표시한다
 */
public class JobTimer implements Runnable {
	@Override
	public void run() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

		System.out.println(now.format(formatter));
	}
}
