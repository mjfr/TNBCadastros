package br.com.animefriends.tnbcadastros.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.animefriends.tnbcadastros.DAOs.UserDAO;
import br.com.animefriends.tnbcadastros.models.User;
import br.com.animefriends.tnbcadastros.utils.SessionUtils;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SessionUtils sessionUtils;

	@GetMapping(value = "/user/new")
	public String openForm() {
		return "user/form";
	}

	@PostMapping(value = "/user/save")
	public String save(User user, RedirectAttributes value,
			@RequestParam(value = "confirmation", required = false) String passwordConfirmation,
			@RequestParam(value = "email", required = false) String emailcomparison) {
		User existingEmail = userDAO.verifyEmail(user.getEmail());// Recebe do banco uma verificação de email
		List<String> errors2 = new ArrayList<>();
		if (user.getName().isEmpty()) {
			errors2.add("Name field is empty");
		}
		if (user.getName().length() < 2) {
			errors2.add("Your name must have at least 2 characters");
		}
		if (user.getName().length() > 60) {
			errors2.add("Your name must have less than 60 characters");
		}
		if (user.getEmail().isEmpty()) {
			errors2.add("E-mail field is empty");
		}
		if (user.getEmail().length() < 7) {
			errors2.add("Your e-mail must have at least 7 characters");
		}
		if (user.getEmail().length() > 100) {
			errors2.add("Your e-mail must have less than 100 characters");
		}
		if (user.getPassword().isEmpty()) {
			errors2.add("Password field is empty");
		}
		if (user.getPassword().length() < 2) {
			errors2.add("Your password must have at least 2 charactersD");
		}
		if (user.getPassword().length() > 20) {
			errors2.add("Your password must have less than 20 characters");
		}
		if (user.getBirthday() == null) {
			errors2.add("Date field is empty");
		} else {
			if (user.getBirthday().getTime() > new Date().getTime()) {
				errors2.add("Your birthday date must be lower than today's date");
			}
		}
		if (user.getGender() == null) {
			errors2.add("No gender was selected");
		}
		if (!(user.getPassword().equals(passwordConfirmation))) {
			errors2.add("Your password doesn't match the confirmation");
		}
		if (!(existingEmail == null)) {
			errors2.add("This e-mail already exists");
		}
		if (!errors2.isEmpty()) {
			value.addFlashAttribute("errors2", errors2);
		} else {
			userDAO.insert(user);
			return "user/login";
		}
		return "redirect:/user/new";
	}

	@GetMapping(value = "/login")
	public String openLogin() {
		return "user/login";
	}

	@PostMapping(value = "/auth")
	public String auth(User user, RedirectAttributes value) {
		List<String> errors = new ArrayList<>(20);
		if (user.getEmail().isEmpty()) {
			errors.add("E-mail field is empty");
		}
		if (user.getPassword().isEmpty()) {
			errors.add("Password field is empty");
		}
		if (!errors.isEmpty()) {
			value.addFlashAttribute("errors", errors);
		} else {
			User authUser = userDAO.auth(user); // Autentica o usuário
			if (authUser != null) {
			sessionUtils.setLoggedUser(authUser); // "Pendura" o usuário em uma sessão
			return "redirect:app/";
			}
		}
		return "redirect:/login";
	}

	@GetMapping(value = "/logout")
	public String doLogout() {
		sessionUtils.KillSession();// Invalida a sessão do usuário
		return "redirect:/";
	}
}
