package com.cipher.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * This Class has been created to solved the Logging cross-cutting concern
 * @author gajagaik
 *
 */
@Aspect
@Configuration
public class LoggerAspect {
	
	

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.cipher.*.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info("Entering in method {}", joinPoint);
	}

	@After(value = "execution(* com.cipher.*.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("After execution of {}", joinPoint);
	}
	
	@AfterThrowing (pointcut = "execution(* com.ciphe.serviceImpl.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable
    {
		logger.error("Exception has been occured",ex.getMessage(),ex);
		
    }
}
