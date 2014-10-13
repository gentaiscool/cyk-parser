package model;

public abstract class Symbol {
	private String name;

	public Symbol(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public Symbol() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
