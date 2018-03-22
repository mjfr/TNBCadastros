package br.com.animefriends.tnbcadastros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/app")
public class LoggedHomeController {

	@GetMapping(value = { "", "/" }) // Ao fazer login, o usuário recebe a chave "/app" e é direcionado a home
	public String openMainPage() {
		return "main/home";
	}

	@GetMapping(value = "/main/home")
	public String openHomePage() {
		return "main/home";
	}
}
