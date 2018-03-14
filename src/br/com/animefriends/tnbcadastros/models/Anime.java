package br.com.animefriends.tnbcadastros.models;

import java.util.Date;

public class Anime {

	private Long id;
	private String name;
	private Date registerDate;
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Anime [id=" + id + ", name=" + name + ", registerDate=" + registerDate + ", user=" + user + "]";
	}
}