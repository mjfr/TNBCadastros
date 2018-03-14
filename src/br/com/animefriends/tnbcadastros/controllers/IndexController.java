package br.com.animefriends.tnbcadastros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public String openIndex() {
		return "index";
	}
}
