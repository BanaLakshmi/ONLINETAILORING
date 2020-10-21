package com.example.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//@Controller
public class MyController {
	@RequestMapping("/")
	public ModelAndView home()
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		UserDao bdao=(UserDao) ctx.getBean("bdao");
		List<User> users = bdao. getUsers();
		System.out.println(users.size());
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("users",users);
		return mv;
	}
	
	@RequestMapping("/add")
	public String add(User user)
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		UserDao bdao=(UserDao) ctx.getBean("bdao");
		bdao.saveUser(user);
		return "redirect:/";
	}

}
