# Java-Scheduling-Example

자바 기반 스케줄링 예제를 종류별로 작성해보았다.

실행은 코드 어딘가 패키지(...)에 있는 EntryPoint 클래스의 main() 메서드를 실행하면 된다.

코드 내용은 모두 최초 실행시 현재 시각을 표시하고 3초 대기 후 1초마다 현재 시각을 표시하는 프로그램이다.

단, 예외가 있는 경우에는 별도 기재한다.

## Java-Timer

java.util.Timer 클래스를 이용한 스케줄링 예제

## Java-Scheduled-Executor-Service

스레드풀 java.util.concurrent.ScheduledExecutorService 을 이용한 스케줄링 예제

## Quartz-with-Java-Config

스케줄링 라이브러리인 Quartz를 이용한, 가장 간단한 스케줄링 예제.

여기서 가장 간단하다는 의미는, 수행할 작업부터 스케줄링 주기까지 모든것을 코드로 작성하였음을 가리킨다.

## Quartz-with-Config-File

Quartz를 이용했다는 점은 동일하나, 수행할 작업만 코드로 작성하고 Quartz 환경설정 자체는 properties 파일과 XML　파일을 이용한 환경설정으로 되어있는 예제.

Quartz의 XML 설정에는 SimpleTrigger의 startAt() 에 해당하는 설정이 없어서, 최초 실행 후 3초 대기 없이 바로 현재 시각이 표시된다.
