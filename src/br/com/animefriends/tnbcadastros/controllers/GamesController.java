package br.com.animefriends.tnbcadastros.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.animefriends.tnbcadastros.DAOs.GameDAO;
import br.com.animefriends.tnbcadastros.models.Game;
import br.com.animefriends.tnbcadastros.models.User;
import br.com.animefriends.tnbcadastros.utils.SessionUtils;

@Controller
@RequestMapping(value = "/app")
public class GamesController {

	@Autowired 
	private GameDAO gameDAO;
	
	@Autowired
	private SessionUtils sessionUtils;
	
	@GetMapping(value = "/game/new")
	public String openMainGamePage() {
		return "games/main";
	}
	
	@GetMapping(value = "/game/form")
	public String openGameForm() {

		return "games/form";
	}
	
	@GetMapping(value = "/game/list")
	public String openGameList(Model model, @RequestParam(name = "id", required = false) Long id) {
		if(id != null) {
			Game game = gameDAO.search(id);
			model.addAttribute("game", game);
		}
		User loggedUser = sessionUtils.getLoggedUser();
		List<Game> games = gameDAO.searchAllByUser(loggedUser);
		model.addAttribute("games", games);
		return "games/list";
	}
	
	@GetMapping(value = "/app/game/delete")
	public String deleteGame(@RequestParam(name = "id", required = true) Long id, Game game){
		game.setId(id);
		gameDAO.delete(game);
		return "redirect:/app/game/list";
	}
	
	@PostMapping(value = "/game/save")
	public String saveGame(Game game) {
		game.setUser(sessionUtils.getLoggedUser());
		game.setRegisterDate(new Date());
		if (game.getId() == null) {
			gameDAO.insert(game);
		} else {
			gameDAO.alter(game);
		}
		return "redirect:/app/game/form";
	}
}
