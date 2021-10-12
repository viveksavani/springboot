package com.springboot.contact.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.contact.Entity.User;
import com.springboot.contact.helper.Message;
import com.springboot.contact.repo.UserRepo;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	UserRepo userRepo;

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model m) {
		m.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("user", new User());
		m.addAttribute("title", "Signup - Smart Contact Manager");
		return "signup";
	}

	@RequestMapping("/do_register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result1,
			@RequestParam("profileImage") MultipartFile file,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model m,
			HttpSession session) {

		if (result1.hasErrors()) {
			System.out.println(result1.toString());
			m.addAttribute("user", user);
			return "signup";
		} else {

			try {
				if (!agreement) {
					System.out.println("You have not agreed Terms and Conditions");
					throw new Exception("You have not agreed Terms and Conditions");
				}

				if (file.isEmpty()) {
					System.out.println("file is empty");
				} else {
					user.setImageUrl(file.getOriginalFilename());
					File file2 = new ClassPathResource("static/img/user").getFile();
					System.out.println(file2);

					Path path = Paths.get(file2.getAbsolutePath() + File.separator + file.getOriginalFilename());

					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Image is Uploaded");
				}

				user.setRole("ROLE_USER");
				user.setEnabled(true);

				user.setPassword(passwordEncoder.encode(user.getPassword()));

				User result = userRepo.save(user);

				System.out.println(agreement);
				System.out.println(user);

				m.addAttribute("user", new User());

				session.setAttribute("message", new Message("SuccessFully Reigster!", "alert-success"));

				return "signup";

			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("user", user);
				session.setAttribute("message", new Message("Something Went Worng!!" + e.getMessage(), "alert-danger"));
				return "signup";
			}

		}

	}

	@RequestMapping("/signin")
	public String login(Model m) {

		m.addAttribute("title", "signin");
		return "login";
	}

}
