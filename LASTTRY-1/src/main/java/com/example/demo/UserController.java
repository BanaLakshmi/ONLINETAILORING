package com.example.demo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {
   
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Home");
		return mv;
	}
	@RequestMapping("/Login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	@RequestMapping("/SignUp")
	public ModelAndView signUp() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("SignUp");
		return mv;
	}
	
	
	
	@RequestMapping("/add")
	public ModelAndView add(Users users,HttpSession session)
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	    UsersDAO udao=(UsersDAO) ctx.getBean("udao");		
	    Users user =  udao.create(users);
	    ModelAndView mv=new ModelAndView();
	    if (user==null)
	    {mv.setViewName("failure");
	    }
	    else
	    	mv.setViewName("question");		
		   session.setAttribute("user", user);	
	    
		return mv;
		
}
	
	@RequestMapping("/savequestion")
	public ModelAndView addSecretQuestions(SecretQuestions secretQuestions) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao=(SecretQuestionsDAO) ctx.getBean("sQdao");
		SecretQuestions secretQuestion= sQdao.saveSecretQuestions(secretQuestions);
		ModelAndView mv=new ModelAndView();
		if(secretQuestion == null) {
			
			mv.setViewName("question");
	        mv.addObject("message","Failed To Register");
			
		}
		else {
			mv.setViewName("Login");
		}
		return mv;
	}
	
	
	@RequestMapping("/verify")
   public ModelAndView validate(String userId, String password, HttpSession session) throws NullPointerException,SQLException {
      
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		UsersDAO udao=(UsersDAO) ctx.getBean("udao");
	    
		ModelAndView mv=new ModelAndView();
		
        Users user = udao.read(userId);
    
             if(user==null)
       {
        	mv.setViewName("Login");
        	mv.addObject("message","User Id Incorrect");
        }
         
       else 
       {  if(password.equals(user.getPassword()))
       	   {
       	         mv.setViewName(user.getCategory());
       	         session.setAttribute("user", user);
        	         
        	         //return new ModelAndView("success");

       	   }
          else
        	  mv.setViewName("Login");
            mv.addObject("message","password Incorrect");
        }
        return mv;
       
   }
	@RequestMapping("/resetpass")
	public String update() {
		return "resetq";
	}
//	@RequestMapping("passreset")
//	public ModelAndView change(String userId,String a1, String a2,String a3,HttpSession session ) throws SQLException {
//		ModelAndView mv=new ModelAndView();
//		 ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//			UsersDAO udao=(UsersDAO) ctx.getBean("udao");
//		
//		SecretQuestions secretQuestions =sQdao.read(userId, a1, a2, a3);
//		if(secretQuestions==null)
//		{
//			mv.setViewName("resetq");
//			mv.addObject("message", "Invalid Answers");
//		}
//		else {
//			session.setAttribute("userId", userId);
//			mv.setViewName("passwordreset");
//		}
//		return mv;
//	}
//	

//	@RequestMapping("/login")
//	public String log()
//	{
//		return "login";
//	}
//	@RequestMapping("/admin")
//	public String admin()
//	{
//		return "admin";
//	}
//	@RequestMapping("/cleaner")
//	public String cleaner()
//	{
//		return "cleaner";
//	}
//	@RequestMapping("/user")
//	public String user()
//	{
//		return "user";
//	}
//	
//	@RequestMapping("/logout")
//	@ResponseBody
//	public String logout(HttpSession session)
//	{
//		session.invalidate();
//		return "Logged Out. Click<a href=login > here </a>to go to login page";
//	}
//	
//	
//	
////	@RequestMapping("/")
////	public ModelAndView home()
////    {
////		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
////		UsersDAO udao=(UsersDAO) ctx.getBean("udao");
////		List<Users> userss = udao.read();
////		System.out.println(userss.size());
////		ModelAndView mv=new ModelAndView();
////		mv.setViewName("Registration");
////		mv.addObject("userss",userss);
////		return mv;
////	}
//
//	@RequestMapping("/register")
//	public ModelAndView register(Users users)
//	{
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//		UsersDAO udao=(UsersDAO) ctx.getBean("udao");
//		udao.create(users);
//		return home();
//	}
//
//	
//	
//	
//	
//// @Autowired 
//// private BookingDAO bookingDAO;
//	 
//	 
//	@RequestMapping("/booking")
//	public ModelAndView home1()
//    {
//	    ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//    	BookingDAO bookingDAO=(BookingDAO) ctx.getBean("bookingDAO");
//		 System.out.println("hello world");
//		List<Booking> books = bookingDAO.read();
//        System.out.println(books.size());
//		ModelAndView mv=new ModelAndView();
//	    mv.setViewName("booking");
//	    mv.addObject("books",books);
//	    return mv;
//	}
//	
//	@RequestMapping("/book")
//	public ModelAndView book(Booking booking )
//	{
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//		BookingDAO bookingDAO=(BookingDAO) ctx.getBean("bookingDAO");
//		bookingDAO.create(booking);
//		return home1();
//	}
//	
//	@RequestMapping("/helpdesk")
//	public ModelAndView home2()
//    {
//	    ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//    HelpDeskDAO helpdao=(HelpDeskDAO) ctx.getBean("helpdao");
//		 System.out.println("hello world");
//		List<HelpDesk> help = helpdao.read();
//        System.out.println(help.size());
//		ModelAndView mv=new ModelAndView();
//	    mv.setViewName("helpdesk");
//	    mv.addObject("help",help);
//	    return mv;
//	}
//	
//	@RequestMapping("/helpd")
//	public ModelAndView helpd(HelpDesk helpdesk )
//	{
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//		HelpDeskDAO helpdao=(HelpDeskDAO) ctx.getBean("helpdao");
//		helpdao.create(helpdesk);
//		return home2();
//	}
//	@RequestMapping("/feedback")
//	public ModelAndView home3()
//    {
//	    ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//    	FeedbackDAO fdao=(FeedbackDAO) ctx.getBean("fdao");
//		 System.out.println("hello world");
//		List<Feedback> feed = fdao.read();
//        System.out.println(feed.size());
//		ModelAndView mv=new ModelAndView();
//	    mv.setViewName("feedback");
//	    mv.addObject("feed",feed);
//	    return mv;
//	}
//	
//	@RequestMapping("/feedb")
//	public ModelAndView feedb(Feedback feedback )
//	{
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//		FeedbackDAO fdao=(FeedbackDAO) ctx.getBean("fdao");
//		fdao.create(feedback);
//		return home3();
//	}
	
}
