package br.com.animefriends.tnbcadastros.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.animefriends.tnbcadastros.models.User;
@Component
public class SessionUtils {

	public static final String USER_KEY = "user";
	
	@Autowired
	private HttpSession session;
	
	public User getLoggedUser() {
		return (User) this.session.getAttribute(USER_KEY);
	}
	
	public void setLoggedUser(User user) {
		session.setAttribute(USER_KEY, user);
	}
	
	public boolean isUserLogged() {
		return session.getAttribute(USER_KEY) != null;
	}
	
	public void KillSession() {
		session.invalidate();
	}
}