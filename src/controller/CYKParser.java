package controller;

import java.util.ArrayList;

import model.Grammar;
import model.NonTerminal;
import model.NonTerminalProduction;
import model.Production;
import model.Terminal;
import model.TerminalProduction;

public class CYKParser {
	/*let the input be a string S consisting of n characters: a1 ... an.
	let the grammar contain r nonterminal symbols R1 ... Rr.
	This grammar contains the subset Rs which is the set of start symbols.
	let P[n,n,r] be an array of booleans. Initialize all elements of P to false.
	for each i = 1 to n
	  for each unit production Rj -> ai
	    set P[i,1,j] = true
	for each i = 2 to n -- Length of span
	  for each j = 1 to n-i+1 -- Start of span
	    for each k = 1 to i-1 -- Partition of span
	      for each production RA -> RB RC
	        if P[j,k,B] and P[j+k,i-k,C] then set P[j,i,A] = true
	if any of P[1,n,x] is true (x is iterated over the set s, where s are all the indices for Rs) then
	  S is member of language
	else
	  S is not member of language*/
	
	private Grammar grammar;
	
	public boolean parse(Grammar grammar, ArrayList<String> strs){
		NonTerminal cat = grammar.getStartSymbol();
		ArrayList<TerminalProduction> tp = grammar.getTerminalProduction();
		ArrayList<NonTerminalProduction> ntp = grammar.getNonTerminalProduction();
		ArrayList<NonTerminal> nt = grammar.getNonTerminals();
		
		this.grammar = grammar;
		boolean[][][] arr = new boolean[strs.size()+1][strs.size()+1][nt.size()+1];
		for(int i=1; i<=strs.size(); i++){
			for(int j=1; j<=strs.size(); j++){
				for(int k=1; k<=nt.size(); k++){
					arr[i][j][k] = false;
				}
			}
		}
		
		for(int i=1; i<=strs.size(); i++){
			for(TerminalProduction prod : tp){
				if(prod.getRhs().get(0).getName().equals(strs.get(i-1))){
					for(int j=1; j<=nt.size(); j++){
						if(nt.get(j-1).getName().equals(prod.getLhs().getName())){
							arr[i][1][j] = true;
							//System.out.println(">>" + i+ " 1 " + j);
						}
					}
				}
			};
		}
		
		for(int i=2; i<=strs.size(); i++){
			for(int j=1; j<=strs.size()-i+1; j++){
				for(int k=1; k<=i-1; k++){
					for(NonTerminalProduction prod : ntp){
						int A = -1, B = -1, C = -1;
						for(int l=1; l<=nt.size(); l++){
							if(nt.get(l-1).getName().equals(prod.getLhs().getName())){
								A = l;
							}
						}
						for(int l=1; l<=nt.size(); l++){
							if(nt.get(l-1).getName().equals(prod.getRhs().get(0).getName())){
								B = l;
							}
						}
						for(int l=1; l<=nt.size(); l++){
							if(nt.get(l-1).getName().equals(prod.getRhs().get(1).getName())){
								C = l;
							}
						}
						
						//System.out.println("[0]" + A + " " + B + " " + C);
						//System.out.println("[1]" + j + " " + k + " " + B);
						//System.out.println("[2]" + (j+k) + " " + (i-k) + " " + C);
						if(arr[j][k][B] && arr[j+k][i-k][C]){
							//System.out.println("true");
							arr[j][i][A] = true;
						}
					}
				}
			}
		}
		
		int idx = 0;
		for(int i=1; i<=nt.size(); i++){
			if(nt.get(i-1).getName().equals(cat.getName())){
				idx = i;
				break;
			}
		}
		
		//System.out.println((nt.size()-1) + " " + idx + " " + cat + " " + (strs.size()-1));
		return arr[1][strs.size()][idx];
	}
}
