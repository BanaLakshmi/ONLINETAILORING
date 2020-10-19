package com.example.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/")
	public ModelAndView home()
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		BranchDAO bdao=(BranchDAO) ctx.getBean("bdao");
		List<Branch> branches = bdao.read();
		System.out.println(branches.size());
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("branches",branches);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(Branch branch)
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		BranchDAO bdao=(BranchDAO) ctx.getBean("bdao");
		bdao.create(branch);
		return home();
	}
}
