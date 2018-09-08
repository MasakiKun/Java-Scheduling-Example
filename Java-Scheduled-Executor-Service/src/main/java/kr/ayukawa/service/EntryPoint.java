package kr.ayukawa.service;

import kr.ayukawa.jobs.JobTimer;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EntryPoint {
	public static void main(String[] args) {
		System.out.println("현재시각: " + LocalDateTime.now().toString());
		System.out.println("3초 후 시각 표시 시작");

		/*
		작업을 스케줄링하기 위해서 ScheduledExecutorService를 사용한다.
		scheduledAtFixedRate() 메서드는 주어진 period마다 한번씩 작업을 실행한다.
		scheduledWitdFixedRate() 메서드는 주어진 작업이 종료된 후, 주어진 delay 후 작업을 실행한다.
		 */
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(
				new JobTimer(),
				3,
				1,
				TimeUnit.SECONDS
		);
	}
}
