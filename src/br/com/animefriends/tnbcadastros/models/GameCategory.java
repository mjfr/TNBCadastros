package br.com.animefriends.tnbcadastros.models;

public enum GameCategory {
	SHOOTER("Shooter"), RPG("RPG"), PLATFORM("Platform"), SPORTS("Sports"), HACKANDSLASH("Hack\'\n Slash"), OTHER("Other");
	
	private final String category;
	
	private GameCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
}