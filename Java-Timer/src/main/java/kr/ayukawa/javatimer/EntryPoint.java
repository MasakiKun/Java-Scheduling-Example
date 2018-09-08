package kr.ayukawa.javatimer;

import java.time.LocalDateTime;
import java.util.Timer;

public class EntryPoint {
	public static void main(String[] args) {
		System.out.println("현재시각: " + LocalDateTime.now().toString());
		System.out.println("2초 후 시각 표시 시작");

		Timer timer = new Timer();
		timer.schedule(
				// 실행할 작업의 인스턴스
				new JobTimer(),
				// delay. 여기서 지정한 시간 이후에 작업이 실행된다
				2000,
				// 작업이 실행될 인터벌. 이 시간 간격으로 작업이 실행된다
				1000
		);
	}
}
