package edu.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.tracing.dtrace.Attributes;

import edu.fa.model.Fresher;
import edu.fa.service.LoginService;

@Controller
public class LoginController {
	
	//@Autowired ..."LoginService" sẽ add class tương ứng ở @Service vào đây 
	//(Giống khởi tạo [new] đối tương  "LoginService" ở đây, nếu không có sẽ lỗi do chưa khởi tạo đối tượng)
	@Autowired
	private LoginService loginService;
	
	 // Với Spring 2.0: kiểu trả về "ModelAndView" là một class có sẵn trong spring
	 //@RequestMapping: là Annotation sẽ mapping với url truyền vào, 
	 //Request truyền vào sẽ tìm annotation có "value" tương ứng 
	/*
	  @RequestMapping(value = "login") 
	  public ModelAndView showLogin() {
	  ModelAndView mav = new ModelAndView("login");
	  //View trả về là  "login.jsp" 
	  mav.addObject("fresher", new Fresher("Ducky", "123456"));
	  //mav.addObject("tên modelAttribute ở form", Đối tượng trả về ở view là Fresher[ở model]) 
	  	return mav; 
	  }
	 */
	
	// Từ Spring 3.0 trở đi: kiểu trả về "String", tham số Model là một class có sẵn trong spring
	/* @RequestMapping: là Annotation sẽ mapping với url truyền vào, */
	/* Request truyền vào sẽ tìm annotation có "value" tương ứng */
	@RequestMapping(value = "login")
	public String showLogin(Model model) {
		model.addAttribute("fresher", new Fresher("Ducky", "Java123"));
		 //model.addAttribute("tên modelAttribute ở form", Đối tượng trả về ở view là Fresher[ở model])
		return "login";// View trả về là "login.jsp"
	}
	
	@RequestMapping(value = "dashboard")
	public String login(@ModelAttribute("fresher") Fresher fresher, Model model) {
		//@ModelAttribute("fresher"): là các thuộc tính sẽ lấy từ form có modelAttribute="fresher", action="dashboard"
		
		//LoginService loginService = new LoginService();
		//nếu không dùng @Autowired thì phải khởi tạo đối tượng ở đây
		
		
		//Kiểm tra nếu Tên đăng nhập khác mật khẩu là đăng nhập đúng
		if( loginService.login(fresher) == true ) {
			model.addAttribute("fresher", fresher);
			//Thuộc tính add vào "model" là Đối tượng "Fresher" với các thông tin đã đăng nhập ở form đăng nhập
			return "dashboard";
		}
		else {
			model.addAttribute("error", true);//Gửi parameter để thông báo lỗi
			return "redirect:login";//redirect: để đổi URL khi đăng nhập sai, nó chuyển URL trang "dashboard" sang "login"( trang đầu)
		}
	}
}
