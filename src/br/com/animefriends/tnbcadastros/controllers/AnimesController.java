package br.com.animefriends.tnbcadastros.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.animefriends.tnbcadastros.DAOs.AnimeDAO;
import br.com.animefriends.tnbcadastros.models.Anime;
import br.com.animefriends.tnbcadastros.models.User;
import br.com.animefriends.tnbcadastros.utils.SessionUtils;

@Controller
@RequestMapping(value = "/app") // Recebe em todos os Get e Post Mappings o /app
public class AnimesController {

	// Injeções de dependências
	@Autowired
	private AnimeDAO animeDAO;

	@Autowired
	private SessionUtils sessionUtils;

	// Abre o formulário recebendo um link pelo GetMapping
	@GetMapping(value = "/anime/new")
	public String openMainAnimePage() {
		return "animes/main";// Retorna o main.jsp
	}

	@GetMapping(value = "/anime/form")
	public String openAnimeForm(Model model, @RequestParam(name = "id", required = false) Long id) {
		if (id != null) {
			Anime anime = animeDAO.search(id);
			model.addAttribute("anime", anime);// Envia as devidas informações à view
		}
		return "animes/form";
	}

	@GetMapping(value = "/anime/list")
	public String openAnimeList(Model model) {
		User loggedUser = sessionUtils.getLoggedUser();
		List<Anime> animes = animeDAO.searchAllByUser(loggedUser);
		model.addAttribute("animes", animes);// Mostrará toda a lista de animes cadastrados pelo usuário
		return "animes/list";
	}

	@GetMapping(value = "/anime/delete")
	public String deleteAnime(@RequestParam(name = "id", required = true) Long id, Anime anime) {
		anime.setId(id);// Coloca o id do anime a ser deletado
		animeDAO.delete(anime);
		return "redirect:/app/anime/list";
	}

	@PostMapping(value = "/anime/save")
	public String saveAnime(Anime anime, RedirectAttributes value) {
		anime.setUser(sessionUtils.getLoggedUser());// Coloca usuário da sessão para a edição do anime
		anime.setRegisterDate(new Date()); // Recebe a data automática do sistema
		List<String> errors4 = new ArrayList<>();// Lista para erros de validação
		if (anime.getName().isEmpty()) {
			errors4.add("Name field is empty");
		}
		if (anime.getName().length() > 40) {
			errors4.add("Anime name is too long, it must have less than 40 characters");
		}
		if (!errors4.isEmpty()) {
			value.addFlashAttribute("errors4", errors4);
		} else {
			if (anime.getId() == null) {
				animeDAO.insert(anime);
				return "redirect:/app/anime/form";/* Ao inserir o anime, o usuário permanece na pagina para futuras
												  inserções*/
			}
			if (anime.getId() != null) {
				animeDAO.alter(anime);
				return "redirect:/app/anime/list";/* Ao editar um anime, o usuário volta a lista de animes para
												  verificar o anime alterado*/
			}
		}
		return "redirect:/app/anime/form";
	}
}
