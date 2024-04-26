package ru.gb.my_first_crud.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
    @AfterReturning(value = "@annotation(TrackUserAction)")
    public void log (){
        System.out.println("Вызван метод помеченный аннотацией AfterReturning");
    }
}
