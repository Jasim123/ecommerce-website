package com.shopit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController 
{
	@RequestMapping("/")
public ModelAndView HomeFunction()
{
	return new ModelAndView("LandingPage");
}
	
	@RequestMapping("/login")
	public ModelAndView LoginFunction()
	{
		return new ModelAndView("LoginPage");
	}
	
	@RequestMapping("/register")
	public ModelAndView RegisterFunction()
	{
		return new ModelAndView("RegisterPage");
	}
	
}
