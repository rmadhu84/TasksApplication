/**
 * 
 */
package com.madhu.spring.tasks.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.madhu.spring.tasks.domain.Task;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramachandranm1
 *
 */
@Aspect
@Slf4j
@Component
public class TaskApplicationAspect {
	

	/*
	 * @Before(value =
	 * "execution(* com.madhu.spring.tasks.service.TaskServiceImpl.*(..)) and args(task)"
	 * ) public void beforeAdvice(JoinPoint joinPoint, Task task) {
	 * System.out.println("Before method:" + joinPoint.getSignature());
	 * 
	 * System.out.println("Creating Employee with name - " + task.getName()); }
	 * 
	 * @After(value =
	 * "execution(* com.madhu.spring.tasks.service.TaskServiceImpl.*(..)) and args(task)"
	 * ) public void afterAdvice(JoinPoint joinPoint, Task task) {
	 * System.out.println("After method:" + joinPoint.getSignature());
	 * 
	 * System.out.println("Successfully created Employee with name - " +
	 * task.getName()); }
	 */
	
	
	@Before(value = "execution(* com.madhu.spring.tasks.service.TaskServiceImpl.*(..))")
	public void logBeforeGetAllTasks(JoinPoint jp) {
		log.info(String.format("Start executing %s", jp.getSignature()));
	}
	
	@After(value = "execution(* com.madhu.spring.tasks.service.TaskServiceImpl.*(..))")
	public void logAfterGetAllTasks(JoinPoint jp) {
		log.info(String.format("Completed executing %s", jp.getSignature()));
		
	}
}
