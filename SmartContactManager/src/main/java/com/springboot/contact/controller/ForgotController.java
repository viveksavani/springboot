package com.springboot.contact.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.contact.Entity.User;
import com.springboot.contact.helper.Message;
import com.springboot.contact.repo.UserRepo;
import com.springboot.contact.service.EmailService;

@Controller
public class ForgotController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;

	Random random = new Random(1000);

	@RequestMapping("/forgot")
	public String forgot(Model m) {

		m.addAttribute("title", "Forgot Password");
		return "forgot";
	}

	@PostMapping("/send-otp")
	public String sendOtp(@RequestParam("email") String email,HttpSession session) {

		System.out.println("email " + email);

		// generating otp

		int otp = random.nextInt(999999);

		System.out.println("OTP " + otp);
		
		//write code for send otp to your email
		
		String subject = "Your Otp For Forgot Password";
		
		String message = 
		"<h1>"+"Your Otp Is "+ otp + "</h1>";
				
				
		
		boolean flag = emailService.sendEmail(subject, message, email);
		
		if(flag) {
			
			session.setAttribute("myotp", otp);
			session.setAttribute("email", email);
			session.setAttribute("message", new Message("We Have Sent Otp To Your Mail!", "alert-success"));
			return "verify_otp";
			
		}
		else {
			
			session.setAttribute("message", new Message("Please Check Your Mail Id!!", "alert-danger"));
			return "forgot";
		}
		
		
	}
	
	
	@PostMapping("verify-otp")
	public String verifyOtp(HttpSession session,@RequestParam("otp") int otp) {
		
		int myotp = (int) session.getAttribute("myotp");
		String email  = (String) session.getAttribute("email"); 
		
		
		
		
		if(myotp==otp) {
			
			User user = userRepo.getUserByName(email);
			
			if(user==null) {
				session.setAttribute("message", new Message("User Does Not Exist With This Email!", "alert-danger"));
				return "forgot";
			}
			else {
				return "change_password";
			}
			
			
			
		}
		
		else {
			session.setAttribute("message", new Message("Your Otp Is Incorrect!", "alert-danger"));
			return "verify_otp";
		}
		
		
	}
	
	@PostMapping("/change-password")
	public String newPassword(@RequestParam("newpassword") String newpassword,HttpSession session) {
		
		
		String email = (String) session.getAttribute("email"); 
		User user = userRepo.getUserByName(email);
		user.setPassword(bcrypt.encode(newpassword));
		userRepo.save(user);
		
		
		
		return "redirect:/signin?change=Password Change SuccessFully!! ";
		
	}

}
