package com.springboot.batch_app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceAspect.class); 
	
	@Around("execution(* com.springboot.batch_app.service.EmployeeService.*(..))")
	public Object recordExecuutionTime(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj =  proceedingJoinPoint.proceed();
		
		long executeTime = System.currentTimeMillis() - startTime; 
		logger.info("Execution time of method:-" +  proceedingJoinPoint.getSignature() + " was: " + executeTime + " milli seconds");
		return obj; 
	}
}
