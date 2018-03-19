package br.com.animefriends.tnbcadastros.models;

import java.util.Date;

public class Game {

	private Long id;
	private String name;
	private GameCategory category;
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

	public GameCategory getCategory() {
		return category;
	}

	public void setCategory(GameCategory category) {
		this.category = category;
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
		return "Game [id=" + id + ", name=" + name + ", category=" + category + ", registerDate=" + registerDate
				+ ", user=" + user + "]";
	}
}