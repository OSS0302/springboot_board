package oss.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


import java.awt.*;

@Aspect
@Component// 자바 빈에 등록해줘야해서 컴포넌트 어노테이션을 써도되고
public class TimeTraceAop {
    @Around("execution(* oss.board.repository.*(..))")// 패키지명  //원하는 곳에 공통 관심사항 적용(타게팅)하기
    public Object execute(ProceedingJoinPoint joinPoint ) throws Throwable {//예외가 터지면 던진다.
        long start = System.currentTimeMillis(); // 시작시간 측정
        System.out.println("START:"+joinPoint.toString());//여기 안에 어떤 메서드를 콜하는 확인
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis(); // 끝난 시간 측정
            long timeMs =  finish= start; // 걸린시간 : 끝난시간 - 시작 시간
            System.out.println("END:"+joinPoint.toString()+" "+timeMs+"ms");//여기 안에 어떤 메서드를 콜하는 확인

        }
    }


}
