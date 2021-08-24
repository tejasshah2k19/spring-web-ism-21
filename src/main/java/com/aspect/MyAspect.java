package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	@Before("execute (* com.controller.RegistrationController.signup(..))")
	public void preProcess() {
		System.out.println("preProcess");
	}

	public void postProcess() {
		System.out.println("postProcess");
	}
}
