package com.example.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class SecretQuestionsContoller {
	@RequestMapping("/")
	public ModelAndView home()
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao=(SecretQuestionsDAO) ctx.getBean("sQdao");
		List<SecretQuestions> secretQuestions =sQdao.read();
		System.out.println(secretQuestions.size());
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("secretQuestions",secretQuestions);
		return mv;
	}
	@RequestMapping("/add")
	public ModelAndView addSecretQuestions(SecretQuestions secretQuestions) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao=(SecretQuestionsDAO) ctx.getBean("sQdao");
	  sQdao.create(secretQuestions);
	return home();
		
	}

}
