package br.com.animefriends.tnbcadastros.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.animefriends.tnbcadastros.models.User;

@Component // Marca a calsse para o Spring injetar um objeto com @Autowired
public class SessionUtils {

	// Armazena a chave onde ficar� o usu�rio autenticado
	public static final String USER_KEY = "user";

	@Autowired
	private HttpSession session;

	// Retorna o usu�rio armazenado na sess�o
	public User getLoggedUser() {
		return (User) this.session.getAttribute(USER_KEY);
	}

	// Guarda o usu�rio que est� logado na sess�o
	public void setLoggedUser(User user) {
		session.setAttribute(USER_KEY, user);
	}

	// Verifica se o usu�rio est� na sess�o
	public boolean isUserLogged() {
		return session.getAttribute(USER_KEY) != null;
	}

	// Invalida a sess�o do cliente
	public void KillSession() {
		session.invalidate();
	}
}