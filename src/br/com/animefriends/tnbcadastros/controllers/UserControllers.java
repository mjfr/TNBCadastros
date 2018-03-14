package br.com.animefriends.tnbcadastros.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.animefriends.tnbcadastros.DAOs.UserDAO;
import br.com.animefriends.tnbcadastros.models.User;
import br.com.animefriends.tnbcadastros.utils.SessionUtils;

@Controller
public class UserControllers {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SessionUtils sessionUtils;
	
	@RequestMapping(value = "/user/new")
	public String openForm() {
		return "user/form";
	}
	
	@PostMapping(value = "/user/save")
	public String save(User user) {
		userDAO.insert(user);
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String openLogin() {
		return "user/login";
	}
	
	@PostMapping(value = "/auth")
	public String auth(User user, Model model) {
		List<String> errors = new ArrayList<>(10);
		if (user.getEmail() == null && user.getEmail().length() < 7 && user.getEmail().length() > 100) {
			errors.add("Your e-mail is obligatory and it must contain between 7 and 60 characters");
		}
		if (user.getPassword() == null && user.getPassword().length() < 2 && user.getPassword().length() > 20) {
			errors.add("Your password is obligatory and it must contain between 2 and 20 characters");
		}
		if (!errors.isEmpty()) {
			model.addAttribute("errors", errors);
			return "user/login";
		}
		
		User authUser = userDAO.auth(user);
		if (authUser == null) {
			return "user/login";
		}
		sessionUtils.setLoggedUser(authUser);
		return "redirect:app/";
	}
	
	@GetMapping(value = "/logout")
	public String doLogout() {
		sessionUtils.KillSession();
		return "redirect:/";
	}
}
