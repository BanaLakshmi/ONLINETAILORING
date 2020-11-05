package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
	public ModelAndView home(HttpSession session) {
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

	@RequestMapping("/SignUp")
	public ModelAndView signUp(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp");
		return mv;
	}
	@RequestMapping("/tailor")
	public ModelAndView tailor(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tailor");
		return mv;
	}
	@RequestMapping("/customer")
	public ModelAndView customer(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		return mv;
	}
	@RequestMapping("/ViewOrder")
	public ModelAndView ViewOrder (HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewOrder");
		return mv;
	}
	@RequestMapping("/ViewCustomerOrder")
	public ModelAndView ViewCustomerOrder (HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewCustomerOrder");
		return mv;
	}
	@RequestMapping("/additionalDetails")
	public ModelAndView additionalDetails(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("additionaldetails");
		return mv;
	}
	
	@RequestMapping("tailordetails")
	public ModelAndView tailordetails(String tailorId,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		System.out.println(tailorId);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDao tailorDao = (TailorDao) ctx.getBean("tailordao");
		TailorDressDAO tailorDressdao = (TailorDressDAO) ctx.getBean("tailorDressdao");
		FeedbackDAO feedbackdao = (FeedbackDAO) ctx.getBean("feedbackDao");
		List<Feedback> feedbackList = feedbackdao.read().stream()
				.filter(f -> f.getTailorId().equalsIgnoreCase(tailorId)).collect(Collectors.toList());
		Tailor tailor = tailorDao.getById(tailorId);
		List<TailorDress> tailorDresses = tailorDressdao.getTailorDressByTailorId(tailorId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tailordetails");
		mv.addObject("tailor", tailor);
		mv.addObject("tailorDresses", tailorDresses);
		mv.addObject("feedbackList", feedbackList);
		return mv;
	}
	
	
//	@RequestMapping("tailorfeedbackpage")
//	public ModelAndView tailorfeedbackpage(String tailorId,HttpSession session) {
//		if(session.getAttribute("user")==null) {
//			return sendToLogin();
//		}
//		System.out.println(tailorId);
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//		FeedbackDAO feedbackdao = (FeedbackDAO) ctx.getBean("feedbackDao");
//		List<Feedback> feedbackList = feedbackdao.read().stream()
//				.filter(f -> f.getTailorId().equalsIgnoreCase(tailorId)).collect(Collectors.toList());
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("feedbackList", feedbackList);
//		mv.setViewName("tailorfeedbackpage");
//		return mv;
//	}

		

	@RequestMapping("/typeofdresses")
	public ModelAndView dresstype(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
		List<DressCategory> dressCategorylist = dressCategoryDAO.getDressCategories();
		mv.addObject("dressCategorylist", dressCategorylist);
		mv.setViewName("typeofdresses");
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(Users users, HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		UsersDAO udao = (UsersDAO) ctx.getBean("udao");
		Users userDb = udao.getByIdOrEmail(users.getUserId(),users.getEmail());
		ModelAndView mv = new ModelAndView();
		if (userDb == null) {
			Users user = udao.create(users);
			if (user == null) {
				mv.setViewName("failure");
			} else
				mv.setViewName("question");
			session.setAttribute("user", user);
		} else {
			mv.setViewName("SignUp");
			mv.addObject("message", "User Id or EmailId already exist please try with a new one");
		}

		return mv;

	}

	@RequestMapping("/savequestion")
	public ModelAndView addSecretQuestions(SecretQuestions secretQuestions,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao = (SecretQuestionsDAO) ctx.getBean("sQdao");
		SecretQuestions secretQuestion = sQdao.saveSecretQuestions(secretQuestions);
		ModelAndView mv = new ModelAndView();
		if (secretQuestion == null) {

			mv.setViewName("question");
			mv.addObject("message", "Failed To Register");

		} else {
			mv.setViewName("Login");
			mv.addObject("message", "New user created successfully");
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
			mv.addObject("message", "User Id not present");
		}

		else {
			if (password.equals(user.getPassword())) {
				mv.setViewName(user.getCategory());
				session.setAttribute("user", user);
			} else {
				mv.setViewName("Login");
				mv.addObject("message", "Password not matching");
			}
			
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
	public ModelAndView change(String userId, String a1, String a2, String a3, HttpSession session)
			throws SQLException {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao = (SecretQuestionsDAO) ctx.getBean("sQdao");

		SecretQuestions secretQuestions = sQdao.read(userId, a1, a2, a3);
		if (secretQuestions == null) {
			mv.setViewName("resetq");
			mv.addObject("message", "Invalid Answers");
		} else {
			session.setAttribute("userId", userId);
			mv.setViewName("passwordreset");
		}
		return mv;
	}

	@RequestMapping("UserIdDisplay")
	public ModelAndView UserIdDisplay(String email, String a1, String a2, String a3, HttpSession session)
			throws SQLException {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		SecretQuestionsDAO sQdao = (SecretQuestionsDAO) ctx.getBean("sQdao");

		SecretQuestions secretQuestions = sQdao.readUserId(email, a1, a2, a3);
		if (secretQuestions == null) {
			mv.setViewName("fetchUserId");
			mv.addObject("message", "Invalid Answers");
		} else {
			session.setAttribute("email", email);
			mv.setViewName("Login");
			mv.addObject("message", "Your User Id is :" + secretQuestions.getUserId());
		}
		return mv;
	}

	@RequestMapping("modifypass")
	public ModelAndView modifypass(String password, String userId,HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		UsersDAO udao = (UsersDAO) ctx.getBean("udao");

		ModelAndView mv = new ModelAndView();

		int no = udao.updatePassword(password, userId);
		if (no == 1) {
			mv.setViewName("Login");
			mv.addObject("message", "Your Password has been updated successfully.");
		} else {
			mv.setViewName("passwordreset");
			mv.addObject("message", "Unable To Change Password");
		}
		return mv;
	}

	@RequestMapping("/logout")

	public String logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}

	@RequestMapping("/searchTailor")
	public ModelAndView searchTailor(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
		List<DressCategory> dressCategorylist = dressCategoryDAO.getDressCategories();
		mv.addObject("dressCategorylist", dressCategorylist);
		mv.setViewName("searchtailor");
		return mv;
	}
	
	@RequestMapping("/createOrder")
	public ModelAndView createOrder(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
		List<DressCategory> dressCategorylist = dressCategoryDAO.getDressCategories();
		mv.addObject("dressCategorylist", dressCategorylist);
		mv.setViewName("CreateOrder");
		return mv;
	}
	
	

	@RequestMapping("getDressKindByCategory")
	@ResponseBody
	public List<String> getDressKindByCategory(int categoryId) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressTypeDAO dressTypeDAO = (DressTypeDAO) ctx.getBean("dTdao");
		List<String> dressKind = dressTypeDAO.getDressKindByCategoryId(categoryId);
		return dressKind.stream().distinct().collect(Collectors.toList());
	}

	@RequestMapping("getDressTypeByDressKindNCategory")
	@ResponseBody
	public List<String> getDressTypeByDressKind(String dressKind, int categoryId) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressTypeDAO dressTypeDAO = (DressTypeDAO) ctx.getBean("dTdao");
		List<String> dressType = dressTypeDAO.getDressTypeByDressKindNCategory(dressKind, categoryId);
		return dressType.stream().distinct().collect(Collectors.toList());
	}
	
	@RequestMapping("getPatternsOnBasisOfSelection")
	@ResponseBody
	public ModelAndView getPatternsOnBasisOfSelection(Integer categoryId, String dressType, String dressKind,String delArea) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDressDAO tailorDressdao = (TailorDressDAO) ctx.getBean("tailorDressdao");
		List<TailorDress> tailorDresses = tailorDressdao.getPatternsOnBasisOfSelection(categoryId, dressType, dressKind,delArea);
		ModelAndView mv = new ModelAndView();
		mv.addObject("tailorDresses",tailorDresses);
		mv.addObject("categoryId",categoryId);
		mv.addObject("dressType",dressType);
		mv.addObject("dressKind",dressKind);
		mv.addObject("delArea",delArea);
		mv.setViewName("CreatePatternOrder");
		return mv;
	}
	@RequestMapping("getCustomerIdbyOrderId")
	@ResponseBody
	public List<String> getCustomerIdbyOrderId(int orderId) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		List<String> customerId = orderDao.getCustomerIdByOrderId(orderId);
		return customerId.stream().distinct().collect(Collectors.toList());
	}
	
	

	@RequestMapping("submittypeOfDresses")
	public ModelAndView addStudent(String tailorId, Integer categoryId, String dressType, String dressKind, Double cost,String typeOfWear,
			HttpServletRequest request,HttpSession session) throws IOException, ServletException {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
//	int studentId=Integer.parseInt(request.getParameter("studentId"));
//	String fullName=request.getParameter("fullName");
		Part part = request.getPart("pattern");
		InputStream inputStream = part.getInputStream();
		int len = inputStream.available();
		byte pattern[] = new byte[len];
		inputStream.read(pattern);
		TailorDress tailorDress = new TailorDress(tailorId, categoryId, dressKind, dressType, pattern, cost,typeOfWear);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDressDAO tailorDressdao = (TailorDressDAO) ctx.getBean("tailorDressdao");
		tailorDressdao.saveTailorDress(tailorDress);
		System.out.println(len);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("typeofdresses");
		mv.addObject("message", "Data has been uploaded successfully");
		return mv;

	}
	
	
	@RequestMapping("placeorder")
	public ModelAndView placeorder(Order order) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		orderDao.saveOrder(order);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		return mv;
	}
	
	@RequestMapping("/adminOrderGallery")
	public  ModelAndView displayAllOrder(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDressDAO tailorDressDAO = (TailorDressDAO) ctx.getBean("tailorDressdao");
		 List<GetOrderDetails> list = tailorDressDAO.getAllOrderDetails();
		ModelAndView mv = new ModelAndView();
		mv.addObject("tailorIds", list);
		mv.setViewName("adminOrderGallery");
		return mv;
}
	
	@RequestMapping("/displayOrderoftailor")
	public  ModelAndView displayAllOrderoftailor(HttpSession session){
		Users user = (Users) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDressDAO tailorDressDAO = (TailorDressDAO) ctx.getBean("tailorDressdao");
		 List<GetOrderDetails> list = tailorDressDAO.getAllOrderDetailsByTailorId(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("tailorIds", list);
		mv.setViewName("tailorOrderGallery");
		return mv;
}
	@RequestMapping("/displayOrderofcustomer")
	public  ModelAndView displayAllOrderofcustomer(HttpSession session){
		Users user = (Users) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDressDAO tailorDressDAO = (TailorDressDAO) ctx.getBean("tailorDressdao");
		 List<GetOrderDetails> list = tailorDressDAO.getAllOrderDetailsByCustomerId(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("tailorIds", list);
		mv.setViewName("customerOrderGallery");
		return mv;
}
	@RequestMapping("/displayOrderbyOrderId")
	public  ModelAndView displayOrderbyOrderId(HttpSession session,Integer orderId){
		Users user = (Users) session.getAttribute("user"); 
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDressDAO tailorDressDAO = (TailorDressDAO) ctx.getBean("tailorDressdao");
		List<GetOrderDetails> list = tailorDressDAO.getAllOrderDetailsByOrderId(orderId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("tailorIds", list);
		mv.setViewName("customerOrderGallery");
		return mv;
}
	
	
	

	@RequestMapping("saveadditionaldetails")
	public ModelAndView saveadditionaldetails(Tailor tailor, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDao tailordao = (TailorDao) ctx.getBean("tailordao");
		Tailor tailorDb = tailordao.getById(tailor.getTailorId());
		if (tailorDb == null) {
			tailordao.saveTailor(tailor);
		} else {
			tailordao.updateTailor(tailor);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("additionaldetails");
		mv.addObject("message", "Your details has been updated successfully");
		return mv;

	}

	@RequestMapping("getDeliveryAreas")
	@ResponseBody
	public List<String> getDeliveryAreas(int categoryId, String dressKind, String dressType) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDao tailorDao = (TailorDao) ctx.getBean("tailordao");
		List<String> deliveryAreas = tailorDao.getDeliveryArea(categoryId, dressKind, dressType);
		List<String> delAreas = new ArrayList<>();
		for (String deliveryArea : deliveryAreas) {
			delAreas.addAll(Arrays.asList(deliveryArea.split(",")));
		}
		return delAreas.stream().distinct().collect(Collectors.toList());
	}

	@RequestMapping("/tailorSearch")
	public ModelAndView tailorSearch(Integer categoryId, String dressType, String dressKind, String delArea,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return sendToLogin();
		}
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		TailorDressDAO tailorDressdao = (TailorDressDAO) ctx.getBean("tailorDressdao");
		List<String> tailorIds = tailorDressdao.read(categoryId, dressType, dressKind, delArea);
		if (tailorIds == null) {
			mv.setViewName("searchtailor");
			mv.addObject("message", "No tailor");
		} else {
			mv.setViewName("searchtailor");
			mv.addObject("tailorIds", tailorIds);
		}

		return mv;
	}
	
	private ModelAndView sendToLogin() {
		ModelAndView mv = new ModelAndView();
			mv.setViewName("Login");
		return mv;
	}
	@RequestMapping("/addDressCategory")
	public ModelAndView addDressCategory (DressCategory dressCategory, HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressCategoryDAO dCdao = (DressCategoryDAO) ctx.getBean("dCdao");
		DressCategory dcDb =  dCdao.getBydressCategoery(dressCategory.getDressCategoery());
		ModelAndView mv = new ModelAndView();
		if (dcDb == null) {
			DressCategory dressCategory1 = dCdao.saveDressCategory(dressCategory) ;
			if (dressCategory1 == null) {
				mv.setViewName("failure");
			} else
				mv.addObject("message", "Dress Category added");
			     mv.setViewName("WelcomeAdmin");
		} else {
			mv.setViewName("DressCategory");
			mv.addObject("message", "Dress Category is alredy added");
		}

		return mv;

	}
	
	@RequestMapping("/DressCategory")
	public ModelAndView DressCategory(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("DressCategory");
		return mv;
	}
	@RequestMapping("/DressType")
	public ModelAndView DressType(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
		List<DressCategory> dressCategorylist = dressCategoryDAO.getDressCategories();
		mv.addObject("dressCategorylist", dressCategorylist);
		mv.setViewName("DressType");
		return mv;
	}
	@RequestMapping("/AdminLogin")
	public ModelAndView adminlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AdminLogin");
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
	@RequestMapping("/addDressType")
	public ModelAndView addDressType (DressType dressType, HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressTypeDAO dTdao = (DressTypeDAO) ctx.getBean("dTdao");
		DressType dtDb =  dTdao.getBydressType(dressType.getDressKind(), dressType.getDressType());
		ModelAndView mv = new ModelAndView();
		if (dtDb == null) {
			DressType dressType1 = dTdao.saveDressType(dressType);
			if (dressType1 == null) {
				mv.setViewName("failure");
			} else
				mv.addObject("message", "Dress Type added");
			     mv.setViewName("WelcomeAdmin");
		} else {
			mv.setViewName("DressType");
			mv.addObject("message", "Dress Kind or Dress Type is alredy added");
		}

		return mv;

	}
	@RequestMapping("/savestatus")
	public ModelAndView addAcceptedOrders(AcceptedOrders acceptedOrders,HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		AcceptedOrdersDao AcceptedOrderddao = (AcceptedOrdersDao) ctx.getBean("AcceptedOrderddao");
		AcceptedOrders AcceptedOrdersDB = AcceptedOrderddao.getByorderId(acceptedOrders.getOrderId());
		ModelAndView mv = new ModelAndView();
		if (AcceptedOrdersDB == null) {
		AcceptedOrders acceptedOrders1 = AcceptedOrderddao.create(acceptedOrders);
		if (acceptedOrders1 == null) {
			mv.setViewName("failure");
			
		} else 
			mv.setViewName("tailor");
			mv.addObject("message", "Last Order is Accepted");
		}else {
			mv.setViewName("tailor");
			mv.addObject("message", "Order ID already exist please try with a new one");
		}
		return mv;
	}
	
	@RequestMapping("/acceptedOrdersGallery")
	public ModelAndView acceptedOrdersGallery(HttpSession session,String tailorId)
	
	{
		Users user = (Users) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		AcceptedOrdersDao AcceptedOrderddao = (AcceptedOrdersDao) ctx.getBean("AcceptedOrderddao");
		List<AcceptedOrders> s = AcceptedOrderddao.getBytailorId(tailorId);
		ModelAndView mv=new ModelAndView();
		if (s == null) {
			mv.setViewName("tailor");
			mv.addObject("message", "No Accepted Order");
		} else {
			mv.setViewName("acceptedOrdersGallery");
			mv.addObject("s",s);
		}
		
		return mv;
	}
	@RequestMapping("/feedbackGallery")
	public ModelAndView feedbackOrdersGallery(HttpSession session,String tailorId)
	
	{
		Users user = (Users) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		FeedbackDAO feedbackDao = (FeedbackDAO) ctx.getBean("feedbackDao");
		List<Feedback> s = feedbackDao.getBytailorId(tailorId);
		ModelAndView mv=new ModelAndView();
		if (s == null) {
			mv.setViewName("tailor");
			mv.addObject("message", "No Feedbacks");
		} else {
			mv.setViewName("feedbackGallery");
			mv.addObject("s",s);
		}
		
		return mv;
	}
	@RequestMapping("/activeOrders")
	public ModelAndView Ordres (HttpSession session,String tailorId,String status)
	
	{
		Users user = (Users) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		AcceptedOrdersDao AcceptedOrderddao = (AcceptedOrdersDao) ctx.getBean("AcceptedOrderddao");
		List<AcceptedOrders> s = AcceptedOrderddao.getByOrderByStatus(tailorId, status);
		ModelAndView mv=new ModelAndView();
		if (s == null) {
			mv.setViewName("tailor");
			mv.addObject("message", "No Order");
		} else {
			mv.setViewName("activeOrders");
			mv.addObject("s",s);
		}
		
		return mv;
	}
	@RequestMapping("/activeCustomerOrders")
	public ModelAndView CustomerOrdres (HttpSession session,String customerId,String status)
	
	{
		Users user = (Users) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		AcceptedOrdersDao AcceptedOrderddao = (AcceptedOrdersDao) ctx.getBean("AcceptedOrderddao");
		List<AcceptedOrders> s = AcceptedOrderddao.getByCustomerOrderByStatus(customerId, status);
		ModelAndView mv=new ModelAndView();
		if (s == null) {
			mv.setViewName("customer");
			mv.addObject("message", "No Order");
		} else {
			mv.setViewName("CustomeractiveOrders");
			mv.addObject("s",s);
		}
		
		return mv;
	}
	

	@RequestMapping("modifystatusoforder")
	public ModelAndView modifystatus(Integer orderId, String status,HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		AcceptedOrdersDao AcceptedOrderddao = (AcceptedOrdersDao) ctx.getBean("AcceptedOrderddao");

		ModelAndView mv = new ModelAndView();

		int no = AcceptedOrderddao.updatestatus(orderId, status);
		if (no == 1) {
			mv.setViewName("ViewOrder");
			mv.addObject("message", "Your Order Status has been updated successfully.");
		} else {
			mv.setViewName("ViewOrder");
			mv.addObject("message", "Unable To Update Order Status");
		}
		return mv;
	}
	
	
	
	

	

//@RequestMapping("/savequestion")
//public ModelAndView addSecretQuestions(SecretQuestions secretQuestions) {
//	ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//	SecretQuestionsDAO sQdao=(SecretQuestionsDAO) ctx.getBean("sQdao");
//	SecretQuestions secretQuestion= sQdao.saveSecretQuestions(secretQuestions);
//	ModelAndView mv=new ModelAndView();
//	if(secretQuestion == null) {
//		
//		mv.setViewName("question");
//        mv.addObject("message","Failed To Register");
//		
//	}
//	else {
//		mv.setViewName("Login");
//	}
//	return mv;
//}

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
