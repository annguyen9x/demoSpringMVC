package edu.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.regexp.internal.recompile;

import edu.fa.model.Fresher;
import edu.fa.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired//Tự động khởi tạo đối tượng "" khi class được gọi
	private RegisterService registerService; 
	
	@RequestMapping(value = "register")
	public String showRegister(Model model) {
		model.addAttribute("fresher2", new Fresher());
		//Truyền vào view "register.jsp" một đối tượng Fresher()
		
		return "register";//Trả về view "register" khi có request yêu cầu
	}
	
	@RequestMapping(value = "userRegister")
	public String showRegister(@ModelAttribute("fresher2") Fresher fresher, Model model) {
		//@ModelAttribute("fresher2"): các thuộc tính sẽ lấy từ form có modelAttribute="fresher2", action="userRegister"
		
		//Nếu đăng ký đúng thì cho về trang login
		if( registerService.register(fresher) == true ) {
			model.addAttribute("fresher2", new Fresher());
			//Truyền vào view "register.jsp" một đối tượng Fresher()
			
			return "redirect: login";//Trả về view "login" khi đăng nhập đúng, "redirect:" sẽ đổi URL tương ứng (login)
		}
		else {
			model.addAttribute("error", true);
			return "redirect: register";//Trả về view "register" và param "error" khi đăng nhập sai
		}
	}
}
