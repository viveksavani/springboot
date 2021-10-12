package com.springboot.contact.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.contact.Entity.Contact;
import com.springboot.contact.Entity.User;
import com.springboot.contact.helper.Message;
import com.springboot.contact.repo.ContactRepo;
import com.springboot.contact.repo.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ContactRepo contactRepo;

	@ModelAttribute
	public void commonMethod(Model model, Principal principal) {
		String email = principal.getName();

		User user = userRepo.getUserByName(email);

		System.out.println("USER" + user);

		model.addAttribute("user", user);

	}

	@RequestMapping("/index")
	public String home(Model model, Principal principal) {

		model.addAttribute("title", "Home");
		return "normal/user_dashboard";
	}

	@GetMapping("/add-contact")
	public String openAddcontactForm(Model model) {

		model.addAttribute("title", "Add Contact");
		model.addAttribute("contact", new Contact());
		return "normal/add_contact_form";
	}

	@GetMapping("/show-contact/{page}")
	public String showcontactForm(@PathVariable("page") int page, Model model, Principal principal) {

		String name = principal.getName();
		User user = userRepo.getUserByName(name);

		PageRequest pagable = PageRequest.of(page, 3);

		Page<Contact> contact = contactRepo.getContactById(user.getId(), pagable);

		model.addAttribute("title", "Show Contact");
		model.addAttribute("contact", contact);
		model.addAttribute("currentpage", page);
		model.addAttribute("totalpage", contact.getTotalPages());
		return "normal/show_contact_form";
	}

	@GetMapping("/contact/delete/{cId}")
	public String deleteContact(@PathVariable("cId") int cId, Model m, Principal principal, HttpSession session) {

		Optional<Contact> optioncontact = contactRepo.findById(cId);
		Contact contact = optioncontact.get();

		String name = principal.getName();
		User user = userRepo.getUserByName(name);

		if (user.getId() == contact.getUser().getId())
			contactRepo.deleteById(cId);

		// session.setAttribute("message", new Message("Contact Deleted Success",
		// "success"));
		return "redirect:/user/show-contact/0";
	}

	@GetMapping("/{cId}/contact")
	public String showContactDetail(@PathVariable("cId") int cId, Model m, Principal principal) {

		Optional<Contact> optioncontact = contactRepo.findById(cId);
		Contact contact = optioncontact.get();

		String name = principal.getName();
		User user = userRepo.getUserByName(name);

		if (user.getId() == contact.getUser().getId()) {
			m.addAttribute("contact", contact);
		}
		return "normal/contact_detail";
	}

	@PostMapping("/{cId}/contactupdate")
	public String openUpdateContactForm(@PathVariable("cId") int cId, Model m, Principal principal) {

		Optional<Contact> optioncontact = contactRepo.findById(cId);
		Contact contact = optioncontact.get();
		m.addAttribute("contact", contact);
		return "normal/contact_update";
	}

	@RequestMapping("/process-contact")
	public String saveContact(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
			Principal principal, HttpSession session) {

		try {
			String name = principal.getName();

			User user = userRepo.getUserByName(name);
			if (file.isEmpty()) {
				System.out.println("file is empty");
				contact.setImage("contact.png");
			} else {
				contact.setImage(file.getOriginalFilename());

				File file2 = new ClassPathResource("static/img/contact").getFile();

				System.out.println(file2);
				Path path = Paths.get(file2.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Image is Uploaded");
			}

			contact.setUser(user);

			user.getContacts().add(contact);

			userRepo.save(user);

			System.out.println("contact added");

			session.setAttribute("message", new Message("Contact Form Added SuccessFully", "success"));

			System.out.println(contact);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("message", new Message("Something Went Wrong!!" + e.getMessage(), "danger"));

		}
		return "normal/add_contact_form";
	}

	@RequestMapping("/process-update")
	public String updateContact(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
			Principal principal, HttpSession session) {

		try {
			String name = principal.getName();

			Contact contact2 = contactRepo.findById(contact.getCid()).get();

			User user = userRepo.getUserByName(name);
			if (!file.isEmpty()) {

				
				//delete photo
				
				File deletefile = new ClassPathResource("static/img/contact").getFile();
				File file1 = new File(deletefile, contact2.getImage());
				file1.delete();
				
				
				//update Photo
				
				File file2 = new ClassPathResource("static/img/contact").getFile();
				Path path = Paths.get(file2.getAbsolutePath() + File.separator + contact2.getCid()+ file.getOriginalFilename());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				contact.setImage( contact2.getCid()+ file.getOriginalFilename());
				System.out.println("Image is Uploaded");

			} else {
				System.out.println("file is empty");
				contact.setImage(contact2.getImage());
			}

			contact.setUser(user);
			contactRepo.save(contact);

			System.out.println("contact added");

			session.setAttribute("message", new Message("Contact Form Updated SuccessFully", "success"));

			System.out.println(contact);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("message", new Message("Something Went Wrong!!" + e.getMessage(), "danger"));

		}
		return "redirect:/user/show-contact/0";
	}
	
	@GetMapping("/profile")
	public String profile(Model m) {
		
		m.addAttribute("title", "Profile Page");
		return "/normal/profile";
	}
	
	@GetMapping("/setting")
	public String setting(Model m) {
		
		m.addAttribute("title", "Settings");
		return "/normal/setting";
	}
	
	@PostMapping("/change-password")
	public String changePassword(Principal principal,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,HttpSession session) {
		
		System.out.println(oldPassword+"oldPassword");
		System.out.println(newPassword+"newPassword");
		
		String username = principal.getName();
		
		User currentUser = userRepo.getUserByName(username);
		
		if(bCryptPasswordEncoder.matches(oldPassword, currentUser.getPassword())) {
			currentUser.setPassword(bCryptPasswordEncoder.encode(newPassword));
			userRepo.save(currentUser);
			session.setAttribute("message", new Message("Password Change SuccessFully", "success"));
		}
		else {
			session.setAttribute("message", new Message("Plase Enter Correct Old Password", "danger"));
		}
		
		return "redirect:/user/setting";
	}

}
