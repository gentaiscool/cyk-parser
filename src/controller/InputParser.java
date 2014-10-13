package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Grammar;
import model.NonTerminal;
import model.NonTerminalProduction;
import model.Production;
import model.Symbol;
import model.Terminal;
import model.TerminalProduction;

public class InputParser {
	public InputParser() {
		// TODO Auto-generated constructor stub
	}

	public Grammar readInput() throws IOException {
		System.out.println("-- LOAD GRAMMAR --");
		Grammar grammar = new Grammar();
		ArrayList<NonTerminalProduction> ntr = new ArrayList<NonTerminalProduction>();
		ArrayList<TerminalProduction> tr = new ArrayList<TerminalProduction>();
		BufferedReader in = new BufferedReader(new FileReader("rules.txt"));

		NonTerminal start = new NonTerminal(in.readLine());

		// read grammar from file input
		String str = in.readLine();
		while (str != null) {
			String[] strs = str.split("->");
			if (strs.length > 1) {
				NonTerminal lhs = new NonTerminal(strs[0].trim());
				if (!strs[0].startsWith("//")) {
					String data = strs[1].trim();
					String[] rhs = data.trim().split(" \\| ");
					for (int i = 0; i < rhs.length; i++) {
						NonTerminal nt = null, nt2 = null;
						Terminal t;
						String[] s = rhs[i].trim().split(" ");
						System.out.println("s >> " + s.length);
						ArrayList<Symbol> arr = new ArrayList<Symbol>();
						if (s.length > 1) {
							if (s[0].charAt(0) >= 'A' && s[0].charAt(0) <= 'Z') {
								nt = new NonTerminal(s[0].trim());
								if (s[1].charAt(0) >= 'A' && s[1].charAt(0) <= 'Z') {
									nt2 = new NonTerminal(s[1].trim());
									arr.add(nt);
									arr.add(nt2);
								} else{
									t = new Terminal(s[1].trim().toLowerCase());
									arr.add(nt);
									arr.add(t);
								}
								grammar.addNonTerminalProduction(lhs, arr);
							} else {
								t = new Terminal(s[0].trim().toLowerCase());
								nt = new NonTerminal(s[1].trim());
								arr.add(t);
								arr.add(nt);
								grammar.addNonTerminalProduction(lhs, arr);
							}
						} else if (s.length == 1) {
							t = new Terminal(s[0].trim().toLowerCase());
							grammar.addTerminalProduction(lhs, t);
						}
					}
					grammar.setStartSymbol(start);
				}
			}
			str = in.readLine();
		}
		in.close();
		System.out.println("Terminal production: " + grammar.getTerminalProduction().size());
		System.out.println("NonTerminal production: " + grammar.getNonTerminalProduction().size());
		System.out.println("-- GRAMMAR LOADED SUCCESSFULLY --");
		return grammar;
	}
}
