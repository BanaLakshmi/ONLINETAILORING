package com.example.demo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        	mv.addObject("message","User Id not present");
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
            mv.addObject("message","Password not matching");
        }
        return mv;
       
   }
	@RequestMapping("/resetpass")
	public String update() {
		return "resetq";
	}
	@RequestMapping("/fetchUserId")
	public String fetchUserId() {
		return "fetchUserId";
	}
	
	
@RequestMapping("passreset")
	public ModelAndView change(String userId,String a1, String a2,String a3,HttpSession session ) throws SQLException {
		ModelAndView mv=new ModelAndView();
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao=(SecretQuestionsDAO) ctx.getBean("sQdao");
	 
	
		SecretQuestions secretQuestions =sQdao.read(userId, a1, a2, a3);
	if(secretQuestions==null)
		{
			mv.setViewName("resetq");
			mv.addObject("message", "Invalid Answers");
		}
		else {
		session.setAttribute("userId", userId);
			mv.setViewName("passwordreset");
	}
		return mv;
	}
@RequestMapping("UserIdDisplay")
public ModelAndView UserIdDisplay(String email,String a1, String a2,String a3,HttpSession session ) throws SQLException {
	ModelAndView mv=new ModelAndView();
	ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	SecretQuestionsDAO sQdao=(SecretQuestionsDAO) ctx.getBean("sQdao");
 

	SecretQuestions secretQuestions =sQdao.readUserId(email, a1, a2, a3);
if(secretQuestions==null)
	{
		mv.setViewName("fetchUserId");
		mv.addObject("message", "Invalid Answers");
	}
	else {
	session.setAttribute("email", email);
		mv.setViewName("Login");
		mv.addObject("message", "Your User Id is :"+secretQuestions.getUserId() );
}
	return mv;
}

@RequestMapping("modifypass")
public ModelAndView modifypass(String password, String userId) 
{
	ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	UsersDAO udao=(UsersDAO) ctx.getBean("udao");
    
	ModelAndView mv=new ModelAndView();

	int no= udao.updatePassword(password, userId);
	if(no==1)
	{
		mv.setViewName("Login");	
		
	}
	else
	{
		mv.setViewName("passwordreset");
		mv.addObject("message","Unable To Change Password");	
	}
	return mv;
}
@RequestMapping("/logout")

public String logout(HttpSession session)
{
	session.invalidate();
	return "Login";
}

@RequestMapping("/searchTailor")
public ModelAndView searchTailor(HttpSession session) {
	ModelAndView mv = new ModelAndView();
	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
	List<DressCategory> dressCategorylist = dressCategoryDAO.getDressCategories();
	mv.addObject("dressCategorylist",dressCategorylist);
	mv.setViewName("tailor");
	return mv;
}
@RequestMapping("getDressKindByCategory")
@ResponseBody
public List<String> getDressKindByCategory(int categoryId)
{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	DressTypeDAO dressTypeDAO = (DressTypeDAO) ctx.getBean("dTdao");
	List<String> dressKind = dressTypeDAO.getDressKindByCategoryId(categoryId);
	return dressKind;
}
@RequestMapping("getDressTypeByDressKindNCategory")
@ResponseBody
public List<String> getDressTypeByDressKind(String dressKind,int categoryId)
{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	DressTypeDAO dressTypeDAO = (DressTypeDAO) ctx.getBean("dTdao");
	List<String> dressType = dressTypeDAO.getDressTypeByDressKindNCategory(dressKind,categoryId);
	return dressType;
}
//@RequestMapping("/tailorUpdate")
//public String home(Model model)
//{
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//	DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
//	List<Department> departments = ddao.read();
//	model.addAttribute("departments",departments);
//	return "index";
//}
//@RequestMapping("getDressKindByCategory")
//@ResponseBody
//public List<String> getDressKindByCategory(int categoryId)
//{
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//	DressTypeDAO dressTypeDAO = (DressTypeDAO) ctx.getBean("dTdao");
//	List<String> dressKind = dressTypeDAO.getDressKindByCategoryId(categoryId);
//	return dressKind;
//}

//@RequestMapping("/getDressKindByCategory")
//public List<DressType> getDressKindByCategory(@RequestParam int categoryId)
//{
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//	DressTypeDAO dressTypeDAO = (DressTypeDAO) ctx.getBean("dTdao");
//	return dressTypeDAO.getDressKind(categoryId);
//}

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
