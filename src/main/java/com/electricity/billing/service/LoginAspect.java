package com.electricity.billing.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoginAspect {
   private final Logger log = LoggerFactory.getLogger(this.getClass());
	
//	@Before("execution(* com.electricity.billing.controller.UserController(..))")
//	public void logBefore(JoinPoint joinPoint) {
//
//		log.info("logBefore() started");
//		log.info("Method Name:" + joinPoint.getSignature().getName());
//		log.info("logBefore() completed!");
//		log.info("******");
//	}

}
