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

import br.com.animefriends.tnbcadastros.DAOs.AnimeDAO;
import br.com.animefriends.tnbcadastros.models.Anime;
import br.com.animefriends.tnbcadastros.models.User;
import br.com.animefriends.tnbcadastros.utils.SessionUtils;

@Controller
@RequestMapping(value = "/app")
public class AnimesController {

	@Autowired
	private AnimeDAO animeDAO;

	@Autowired
	private SessionUtils sessionUtils;

	@GetMapping(value = "/anime/new")
	public String openMainAnimePage() {
		return "animes/main";
	}

	@GetMapping(value = "/anime/form")
	public String openAnimeForm() {
		return "animes/form";
	}

	@GetMapping(value = "/anime/list")
	public String openAnimeList(Model model, @RequestParam(name = "id", required = false) Long id) {
		if (id != null) {
			Anime anime = animeDAO.search(id);
			model.addAttribute("anime", anime);
		}
		User loggedUser = sessionUtils.getLoggedUser();
		List<Anime> animes = animeDAO.searchAllByUser(loggedUser);
		model.addAttribute("animes", animes);
		return "animes/list";
	}

	@GetMapping(value = "/anime/delete")
	public String deleteAnime(@RequestParam(name = "id", required = true) Long id, Anime anime) {
		anime.setId(id);
		animeDAO.delete(anime);
		return "redirect:/app/anime/list";
	}

	@PostMapping(value = "/anime/save")
	public String saveAnime(Anime anime) {
		anime.setUser(sessionUtils.getLoggedUser());
		anime.setRegisterDate(new Date());
		if (anime.getId() == null) {
			animeDAO.insert(anime);
		} else {
			animeDAO.alter(anime);
		}
		return "redirect:/app/anime/form";
	}
}
