package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Grammar {
	private NonTerminal startSymbol;
	private ArrayList<NonTerminal> nonTerminals;
	private ArrayList<Terminal> terminals;
	
	private ArrayList<NonTerminalProduction> nonTerminalProduction;
	private ArrayList<TerminalProduction> terminalProduction;
	
	private HashMap<NonTerminal, Boolean> mapNT;
	private HashMap<Terminal, Boolean> mapT;

	public Grammar() {
		// TODO Auto-generated constructor stub
		startSymbol = new NonTerminal();
		nonTerminals = new ArrayList<NonTerminal>();
		terminals = new ArrayList<Terminal>();
		
		nonTerminalProduction = new ArrayList<NonTerminalProduction>();
		terminalProduction = new ArrayList<TerminalProduction>();
	
		mapNT = new HashMap<NonTerminal, Boolean>();
		mapT = new HashMap<Terminal, Boolean>();
	}
	
	public void addTerminalProduction(NonTerminal lhs, Terminal rhs){
		ArrayList<Symbol> t = new ArrayList<Symbol>();
		t.add(rhs);
		TerminalProduction prod = new TerminalProduction(lhs, t);
		terminalProduction.add(prod);
		if(!mapT.containsKey(rhs)){
			mapT.put(rhs, true);
			terminals.add(rhs);
		}
		if(!mapNT.containsKey(lhs)){
			mapNT.put(lhs, true);
			nonTerminals.add(lhs);
		}
	}
	
	public void addNonTerminalProduction(NonTerminal lhs, ArrayList<Symbol> rhs){
		NonTerminalProduction prod = new NonTerminalProduction(lhs, rhs);
		nonTerminalProduction.add(prod);
		if(!mapNT.containsKey(lhs)){
			mapNT.put(lhs, true);
			nonTerminals.add(lhs);
		}
	}

	public NonTerminal getStartSymbol() {
		return startSymbol;
	}

	public void setStartSymbol(NonTerminal startSymbol) {
		this.startSymbol = startSymbol;
	}

	public ArrayList<NonTerminal> getNonTerminals() {
		return nonTerminals;
	}

	public void setNonTerminals(ArrayList<NonTerminal> nonTerminals) {
		this.nonTerminals = nonTerminals;
	}

	public ArrayList<Terminal> getTerminals() {
		return terminals;
	}

	public void setTerminals(ArrayList<Terminal> terminals) {
		this.terminals = terminals;
	}

	public ArrayList<NonTerminalProduction> getNonTerminalProduction() {
		return nonTerminalProduction;
	}

	public void setNonTerminalProduction(
			ArrayList<NonTerminalProduction> nonTerminalProduction) {
		this.nonTerminalProduction = nonTerminalProduction;
	}

	public ArrayList<TerminalProduction> getTerminalProduction() {
		return terminalProduction;
	}

	public void setTerminalProduction(
			ArrayList<TerminalProduction> terminalProduction) {
		this.terminalProduction = terminalProduction;
	}
}
