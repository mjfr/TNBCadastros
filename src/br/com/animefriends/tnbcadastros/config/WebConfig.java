package br.com.animefriends.tnbcadastros.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import br.com.animefriends.tnbcadastros.interceptors.InterceptorAuthentication;

@Configuration //Determina esta classe como uma classe de configura��o
@EnableWebMvc //Habilita o m�dulo de MVC do Spring
@ComponentScan("br.com.animefriends.tnbcadastros") //Mapeia as anota��es relacionadas ao Spring
public class WebConfig implements WebMvcConfigurer {

	@Autowired//Injeta o interceptor para utilizar no addInterceptors
	private InterceptorAuthentication interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {//Registra todos os interceptors utilizados
		registry.addInterceptor(interceptor).addPathPatterns("/**");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {//� determinado onde as views ser�o encontradas
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		registry.viewResolver(resolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {//Design (css, js, etc) ser�o determinados por aqui
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");// 1�* nome 2�* extens�o
	}
}
