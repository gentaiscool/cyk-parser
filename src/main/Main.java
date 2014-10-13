package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Grammar;
import controller.CYKParser;
import controller.InputParser;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Character[] delimiter = new Character[]{'.',',','!','[',']'};
		
		InputParser ip = new InputParser();
		Grammar grammar = ip.readInput();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		for(int i=0; i<delimiter.length; i++){
			input = input.replace(delimiter[i], ' ');
		}
		String[] arr = input.toLowerCase().trim().split(" ");
		ArrayList<String> strs = new ArrayList<String>();
		for(int i=0; i<arr.length; i++){
			strs.add(arr[i].trim());
		}
		
		CYKParser parser = new CYKParser();
		System.out.println(grammar.getStartSymbol().getName() + " " + grammar.getNonTerminals().size());
		System.out.println(parser.parse(grammar, strs));
	}

}
