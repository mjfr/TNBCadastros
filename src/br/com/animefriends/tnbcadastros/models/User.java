package br.com.animefriends.tnbcadastros.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private Long id;
	private String name;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Gender gender;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthday="
				+ birthday + ", gender=" + gender + "]";
	}
}