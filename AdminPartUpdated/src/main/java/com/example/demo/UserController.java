package com.example.demo;
//using System.Data;

import java.sql.SQLException;
import org.springframework.ui.ModelMap;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home");
		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}

	@RequestMapping("/AdminLogin")
	public ModelAndView adminlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AdminLogin");
		return mv;
	}

	@RequestMapping("/AdminAddCategories")
	public ModelAndView adminAddCategories() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AdminAddCategories");
		return mv;
	}

	@RequestMapping("/AdminsubmitCategories")
	public ModelAndView adminSubmitCategories(DressCategory dressCategory, HttpSession session, ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressCategoryDAO Ddao = (DressCategoryDAO) ctx.getBean("Ddao");
		System.out.println(dressCategory.getDressCategory());
		DressCategory dressCategory1 = Ddao.create(dressCategory);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AdminAddedCategory");
		session.setAttribute("dressCategory1", dressCategory1);
		return mv;

	}

	@RequestMapping("/SignUp")
	public ModelAndView signUp() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp");
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(Users users, HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		UsersDAO udao = (UsersDAO) ctx.getBean("udao");
		Users user = udao.create(users);
		ModelAndView mv = new ModelAndView();
		if (user == null) {
			mv.setViewName("failure");
		} else
			mv.setViewName("question");
		session.setAttribute("user", user);

		return mv;

	}

	@RequestMapping("/savequestion")
	public ModelAndView addSecretQuestions(SecretQuestions secretQuestions) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao = (SecretQuestionsDAO) ctx.getBean("sQdao");
		SecretQuestions secretQuestion = sQdao.saveSecretQuestions(secretQuestions);
		ModelAndView mv = new ModelAndView();
		if (secretQuestion == null) {

			mv.setViewName("question");
			mv.addObject("message", "Failed To Register");

		} else {
			mv.setViewName("Login");
		}
		return mv;
	}

	@RequestMapping("/verify")
	public ModelAndView validate(String userId, String password, HttpSession session)
			throws NullPointerException, SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		UsersDAO udao = (UsersDAO) ctx.getBean("udao");

		ModelAndView mv = new ModelAndView();

		Users user = udao.read(userId);

		if (user == null) {
			mv.setViewName("Login");
			mv.addObject("message", "User Id Incorrect");
		}

		else {
			if (password.equals(user.getPassword())) {
				mv.setViewName("WelcomeUser");
				session.setAttribute("user", user);

			} else
				mv.setViewName("Login");
			mv.addObject("message", "password Incorrect");
		}
		return mv;

	}

	@RequestMapping("/verifyAdmin")
	public ModelAndView validateAdmin(String adminId, String password, HttpSession session)
			throws NullPointerException, SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		AdminDao adao = (AdminDao) ctx.getBean("Adao");

		ModelAndView mv = new ModelAndView();

		Admin admin = adao.read(adminId);

		if (admin == null) {
			mv.setViewName("AdminLogin");
			mv.addObject("message", "adminId not matching");

			return mv;
		} else {
			if (!(admin.getPassword().equals(password))) {
				mv.setViewName("AdminLogin");
				mv.addObject("message", "password not matching");

				return mv;
			} else {
				return new ModelAndView("WelcomeAdmin");
			}

		}

	}

	@RequestMapping("/resetpass")
	public String update() {
		return "resetq";
	}

	@RequestMapping("/help")
	public ModelAndView help(ModelMap model) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("date", LocalDate.now());
		mv.setViewName("UserHelp");
		return mv;
	}

	@RequestMapping("/saveHelp")
	public ModelAndView saveHelp(Help help, HttpSession session, ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		HelpDAO hdao = (HelpDAO) ctx.getBean("Hdao");
		Help help1 = hdao.create(help);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WelcomeUser");
		session.setAttribute("help1", help1);
		return mv;

	}

	@RequestMapping("/helpRequestForAdmin")
	public ModelAndView helpRequestForAdmin(HttpSession session, ModelMap map) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		HelpDAO hdao = (HelpDAO) ctx.getBean("Hdao");
		List<Help> helpRequests = hdao.read();
		ModelAndView mv = new ModelAndView();
		if (helpRequests.isEmpty()) {

			mv.setViewName("NoRequestsForAdmin");
			mv.addObject("message", "No requets yet...");

		} else {
			
			session.setAttribute("helpRequests", helpRequests);

			mv.setViewName("AdminHelpRequests");
		}
		return mv;

	}
	// @Model

	@RequestMapping("/helpRequestDetailsForAdmin")
	public ModelAndView helpRequestDetailsForAdmin(int requestId, HttpSession session, ModelMap map) {
       System.out.println(requestId);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		HelpDAO hdao = (HelpDAO) ctx.getBean("Hdao");
		Help help = hdao.read(requestId);
		session.setAttribute("help", help);
		//map.addAttribute("help", help);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AdminHelpRequestDetails");
		return mv;

	}

	/*
	 * @RequestMapping("/saveResolution") public ModelAndView
	 * saveResolution(@ModelAttribute("help") Help help, HttpSession session,
	 * ModelMap map) throws NullPointerException {
	 * 
	 * // System.out.
	 * println("the request id is..........................................."
	 * +requestId); // Help help1=(Help) session.getAttribute("help");
	 * ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	 * HelpDAO hdao = (HelpDAO) ctx.getBean("Hdao");
	 * 
	 * //Help help2=hdao.read(requestId); int requestID=help.getRequestId(); String
	 * resolution = help.getResolution(); help.setResolution(resolution); Help
	 * help1=hdao.update(help);
	 * 
	 * System.out.println(requestID); System.out.println(resolution);
	 * System.out.println(help.toString());
	 * 
	 * // hdao.updateResolution(resolution);
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * mv.setViewName("AdminResolutionSuccess"); return mv;
	 * 
	 * }
	 */
	@RequestMapping("/saveResolution")
	public ModelAndView saveResolution(String resolution, HttpSession session, ModelMap map)
			throws NullPointerException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		HelpDAO hdao = (HelpDAO) ctx.getBean("Hdao");
		Help help=(Help) session.getAttribute("help");
		int no=hdao.updateResolution(resolution,help.getRequestId());
		//System.out.println(help.getRequestId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AdminResolutionSuccess");

		return mv;

	}

}
