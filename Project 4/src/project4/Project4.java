package project4;

import java.util.*;

class Card {
	private char symbol;
	private int number;
	
	public Card(char symbol, int number) {
		this.setSymbol(symbol);
		this.setNumber(number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}

public class Project4 {
	private static final Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		Map<Character, ArrayList<Card>> map = new TreeMap<>();
		
		System.out.print("Enter the number of cards: ");
		int n = in.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter card " + i);
			char symbol = in.next().charAt(0);
			int number = in.nextInt();
			
			Card c = new Card(symbol, number);
			
			if(!map.containsKey(symbol)) {
				ArrayList<Card> list = new ArrayList<>();
				list.add(c);
				map.put(symbol, list);
			}
			else {
				ArrayList<Card> list = map.get(symbol);
				list.add(c);
			}			
		}
		System.out.println("Distinct Symbols are: ");
		Set<Character> distinctSymbols = map.keySet();
		for(Character c: distinctSymbols) {
			System.out.print(c + " ");
		}
		System.out.println();
		for(Map.Entry<Character, ArrayList<Card>> entry: map.entrySet()) {
			ArrayList<Card> cards = entry.getValue();
			int sum = 0;
			
			System.out.println("Cards in " + entry.getKey() + " Symbol");
			for(Card c: cards) {
				System.out.println(c.getSymbol() + " " + c.getNumber());
				sum += c.getNumber();
			}
			System.out.println("Number of cards: " + cards.size());
			System.out.println("Sum of Numbers: " + sum);
		}
	}
	
}
