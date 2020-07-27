package com.electricity.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.electricity.exception.ElectricityException;

@ControllerAdvice
public class ElectricityExceptionController {
	
	@ExceptionHandler(value= ElectricityException.class)
	public ModelAndView exception(ElectricityException ee) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("message",ee.getExceptionMesg());
		mv.setViewName("error");
		
		return mv;
	}

}
