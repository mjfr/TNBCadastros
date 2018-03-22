package br.com.animefriends.tnbcadastros.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.animefriends.tnbcadastros.DAOs.UserDAO;
import br.com.animefriends.tnbcadastros.models.User;
import br.com.animefriends.tnbcadastros.utils.SessionUtils;

@Controller
@RequestMapping(value = "/app")
public class UserOptionsController {
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SessionUtils sessionUtils;
	
	@GetMapping(value = "/option/new")
	public String openOptions() {
		return "options/main";
	}
	
	@GetMapping(value = "/options/edit/data")
	public String openEditData() {
		return "options/change-register-data";
	}
	
	@PostMapping(value = "/options/edit/data")
	public String editData(User user, RedirectAttributes value) {
		user.setId(sessionUtils.getLoggedUser().getId());
		userDAO.editData(user);
		return "redirect:/app/main/home";
	}
	
	@GetMapping(value = "/options/edit/password")
	public String openEditPassword() {
		return "options/change-password";
	}
	
	@PostMapping(value = "/options/edit/password")
	public String editPassword(User user, RedirectAttributes value, @RequestParam(value = "confirmation", required = false) String newPasswordConfirmation,
			@RequestParam(value = "oldPassword", required = false) String oldPassword) {
		user.setId(sessionUtils.getLoggedUser().getId());
		String oldPsd = sessionUtils.getLoggedUser().getPassword();
		List<String> errors5 = new ArrayList<>();
		if(!(user.getPassword().equals(newPasswordConfirmation))) {
			errors5.add("Your new password doesn't match the confirmation");
		}
		if (user.getPassword().isEmpty()) {
			errors5.add("Password field is empty");
		}
		if (oldPassword.isEmpty()) {
			errors5.add("To change your password, you need to fill your old password first");
		}
		if (newPasswordConfirmation.isEmpty() && user.getPassword().isEmpty()) {
			errors5.add("To change your password, you need to write your new password again to confirm if it's rigth or not");
		}
		if (user.getPassword().length() < 2) {
			errors5.add("Your password must have at least 2 characters");
		}
		if (user.getPassword().length() > 20) {
			errors5.add("Your password must have less than 20 characters");
		}
		if (!(oldPassword.equals(oldPsd)) && !oldPassword.isEmpty()) {
			errors5.add("Your old password doens't match with the already registered");
		}
		if (!errors5.isEmpty()) {
			value.addFlashAttribute("errors5", errors5);
		} else {
			userDAO.editPassword(user);
			sessionUtils.KillSession();
			return "redirect:../../../login";
		}
		return "redirect:/app/options/edit/password";
	}
	
}
