package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Grammar;
import model.Node;
import model.Tuple;
import controller.CYKParser;
import controller.InputParser;

public class Main {

	private Tuple<Boolean, ArrayList<Node>, Integer> result;

	public Main(String input) throws IOException {
		// TODO Auto-generated constructor stub
		Character[] delimiter = new Character[] { '.', ',', '!', '[', ']' };

		InputParser ip = new InputParser();
		Grammar grammar = ip.readInput();

		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		// String input = in.readLine();
		for (int i = 0; i < delimiter.length; i++) {
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == delimiter[i])
					input = input.substring(0, j) + input.substring(j + 1);
			}
		}
		// System.out.println(input);
		String[] arr = input.toLowerCase().trim().split(" ");
		ArrayList<String> strs = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			strs.add(arr[i].trim());
		}

		CYKParser parser = new CYKParser();
		// System.out.println(grammar.getStartSymbol().getName() + " " +
		// grammar.getNonTerminals().size());

		result = parser.parse(grammar, strs);
		if (result.getA()) {
			System.out.println("Sentence is valid");
		} else {
			System.out.println("Sentence is not valid");
		}
	}

	public Tuple<Boolean, ArrayList<Node>, Integer> getResult() {
		return result;
	}

	public void setResult(Tuple<Boolean, ArrayList<Node>, Integer> result) {
		this.result = result;
	}

}
