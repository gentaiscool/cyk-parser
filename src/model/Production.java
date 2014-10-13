package model;

import java.util.ArrayList;

public abstract class Production {

	public enum Type {
		T, NT_T, T_NT, EMPTY, NT_NT
	};

	private Type type;
	protected NonTerminal lhs;
	protected ArrayList<Symbol> rhs;
	
	public Production() {
		// TODO Auto-generated constructor stub
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public NonTerminal getLhs() {
		return lhs;
	}

	public void setLhs(NonTerminal lhs) {
		this.lhs = lhs;
	}

	public ArrayList<Symbol> getRhs() {
		return rhs;
	}

	public void setRhs(ArrayList<Symbol> rhs) {
		this.rhs = rhs;
	}
}
