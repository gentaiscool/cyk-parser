package model;

import java.util.ArrayList;

public class NonTerminalProduction extends Production{
	
	public NonTerminalProduction(NonTerminal lhs, ArrayList<Symbol> rhs) {
		// TODO Auto-generated constructor stub
		super();
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
}
