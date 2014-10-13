package model;

import java.util.ArrayList;

public class TerminalProduction extends Production {

	public TerminalProduction(NonTerminal lhs, ArrayList<Symbol> rhs) {
		// TODO Auto-generated constructor stub
		super();
		this.lhs = lhs;
		this.rhs = rhs;
	}
}
