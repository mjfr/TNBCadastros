package br.com.animefriends.tnbcadastros.models;

public enum Gender {

	MALE("Male"), FEMALE("Female"), OTHER("Other");
	
	private final String name;
	
	private Gender(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}