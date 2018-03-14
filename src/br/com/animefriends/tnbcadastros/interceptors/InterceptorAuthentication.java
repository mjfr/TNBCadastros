package br.com.animefriends.tnbcadastros.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.animefriends.tnbcadastros.utils.SessionUtils;

@Component
public class InterceptorAuthentication extends HandlerInterceptorAdapter{

	@Autowired
	private SessionUtils sessionUtils;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean needAuthentication = request.getRequestURI().contains("/app");
		if (needAuthentication && ! sessionUtils.isUserLogged()) {
			response.setStatus(401);
			return false;
		} else {
			return true;
		}
		
	};
	
}
