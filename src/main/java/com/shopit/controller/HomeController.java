package com.shopit.controller;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopit.dao.UserDao;
import com.shopit.model.UserDetail;

@Controller
public class HomeController 
{
	@Autowired
	UserDao userdao;
	
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
	

	@RequestMapping("/reg")
	public ModelAndView SignUp()
	{
		UserDetail userDetail=new UserDetail();
		return new ModelAndView("RegisterPage","UserDetails",userDetail);
	}

	@RequestMapping("/register")
	public ModelAndView RegisterProcess(@Valid @ModelAttribute("UserDetails") UserDetail user, BindingResult br , HttpServletRequest request)
	{

		if(br.hasErrors())
		{
			return new ModelAndView("RegisterPage");
		}
		userdao.saveorupdate(user);
		return new ModelAndView("RegisterPage");
	}
	
}



	

