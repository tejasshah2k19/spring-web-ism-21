package com.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler({ NullPointerException.class, ArrayIndexOutOfBoundsException.class })
	public String exceptionHandler() {
		return "Error";
	}
}
