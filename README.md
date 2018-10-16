# Java-Scheduling-Example

자바 기반의 작업 스케줄링 프로그램을 이런저런 라이브러리 등을 이용해서 작성해보았다.

모든 프로그램은 최초 실행시 현재 시각을 표시하고 3초 대기 후 1초마다 현재 시각을 표시한다. 단, 예외가 있는 경우에는 별도 기재한다.

여기서는 정해진 주기에 맞춰 작업을 수행하는 것만을 다룬다. cron을 이용하여 정해진 시점에 작업을 수행하는 내용은 다루지 않는다.

## 실행

실행은 코드 어딘가 패키지(...)에 있는 EntryPoint 클래스의 main() 메서드를 실행하면 된다.

## 프로젝트 목록

### Java-Timer

java.util.Timer 클래스를 이용한 스케줄링 예제

### Java-Scheduled-Executor-Service

스레드풀 java.util.concurrent.ScheduledExecutorService 을 이용한 스케줄링 예제

### Quartz-with-Java-Config

스케줄링 라이브러리인 Quartz를 이용한, 가장 간단한 스케줄링 예제.

여기서 가장 간단하다는 의미는, 수행할 작업부터 스케줄링 주기까지 모든것을 코드로 작성하였음을 가리킨다.

### Quartz-with-Config-File

Quartz를 이용했다는 점은 동일하나, 수행할 작업만 코드로 작성하고 Quartz 환경설정 자체는 properties 파일과 XML 파일을 이용한 환경설정으로 되어있는 예제.

Quartz의 XML 설정에는 SimpleTrigger의 startAt() 에 해당하는 설정이 없어서, 최초 실행 후 3초 대기 없이 바로 현재 시각이 표시된다.

### Quartz-and-SpringFramework-XML-Config

Quartz의 스케줄러, Job, Trigger를 스프링 컨테이너가 관리하도록 한 예제. 이 예제에서는 스프링의 메타 데이터를 네임스페이스 기반의 XML로 작성했다. 

참고로 Quartz와 Spring Framework는 각각 관리하는 객체들의 생명주기가 달라서, 일반적인 방법으로는 스프링 컨테이너가 관리하는 빈을 Quartz의 Job에 주입할 수 없다고 한다.

Quartz의 Job에 스프링 컨테이너가 관리하는 빈을 주입하기 위해서는 JobDataMap 이라는 프로퍼티에 직접 빈을 주입해주어야 한다. 

이 예제에서는 이 부분은 생략했다.

### Quartz-and-SpringFramework-Java-Config

Quartz + Spring Framework 예제를 Java Config 형태로 구현한 예제. 동작은 동일하다.

### Spring-Scheduling-Task-with-XML-Config

Spring에 내장된 Task과 Scheduling을 XML Config 형태로 구현한 예제. 동작은 동일하다.

### Spring-Scheduling-Task-with-Annotation

Spring에 내장된 Task와 Scheduling을 어노테이션을 이용해서 구현한 예제. 동작은 동일하다.

## References

  * 자바 기반 스케줄링 프로그래밍
    * [1. 개요](http://blog.cjred.net/entry/%EC%9E%90%EB%B0%94%EA%B8%B0%EB%B0%98-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D1-%EA%B0%9C%EC%9A%94)
    * [2. cron 명령어](http://blog.cjred.net/entry/%EC%9E%90%EB%B0%94%EA%B8%B0%EB%B0%98-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D2-cron-%EB%AA%85%EB%A0%B9%EC%96%B4)
    * [3. java.util.Timer](http://blog.cjred.net/entry/%EC%9E%90%EB%B0%94%EA%B8%B0%EB%B0%98-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D3-javautilTimer)
    * [4. Quartz](http://blog.cjred.net/entry/%EC%9E%90%EB%B0%94%EA%B8%B0%EB%B0%98-%EC%8A%A4%EC%BC%80%EC%A5%B4%EB%A7%81-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D4-Quartz)
    * [5. Quartz + CronTrigger](http://blog.cjred.net/entry/%EC%9E%90%EB%B0%94%EA%B8%B0%EB%B0%98-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D5-Quartz-CronTrigger)
    * [6. Quartz + Spring](http://blog.cjred.net/entry/%EC%9E%90%EB%B0%94%EA%B8%B0%EB%B0%98-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D6-Quartz-Spring)
    * [7. Quartz vs Jenkins](http://blog.cjred.net/entry/%EC%9E%90%EB%B0%94%EA%B8%B0%EB%B0%98-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D7-Quartz-vs-Jenkins)
  * [자바 스케쥴링 & 타이머 방법들](http://hamait.tistory.com/211)
  * [Example to run multiple jobs in Quartz](https://www.mkyong.com/java/example-to-run-multiple-jobs-in-quartz/)
  * [Configure Quartz Scheduler Jobs using XML File](https://www.mkyong.com/java/example-to-run-multiple-jobs-in-quartz/)
  * [ Spring 4 + Quartz 2 Scheduler Integration Annotation Example using JavaConfig](https://www.concretepage.com/spring-4/spring-4-quartz-2-scheduler-integration-annotation-example-using-javaconfig)
  * [Spring Scheduler(스프링 스케쥴러) 설정방법 및 사용방법](https://blog.naver.com/cyon24/203674742)
  * [생활코딩 - 스프링 스케줄러](https://opentutorials.org/module/2068/12058)
  * [Spring Scheduling 작동 주기 동적으로 설정하기](http://tech.javacafe.io/2018/05/30/dynamic_scheduling/)
  * [Spring @Scheduled 어노테이션](http://logtree.tistory.com/26)
  * [[Spring 레퍼런스] 26장 태스크(Task) 실행과 스케줄링](https://blog.outsider.ne.kr/1066)
  