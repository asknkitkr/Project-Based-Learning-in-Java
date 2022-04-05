package project5;

import java.util.Scanner;
import java.util.HashSet;

class Card {
	String symbol;
	int number;
	
	Card(String s, int n) {
		symbol = s;
		number = n;
	}
}

public class Project5 {
	private static final Scanner in = new Scanner(System.in);
	public static boolean checkSymbol(HashSet<Card> card, String sym) {
		for(Card c: card) {
			if(c.symbol.equals(sym)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int count = 0;
		HashSet<Card> card = new HashSet<Card>();
		
		while(count < 4) {
			System.out.print("Enter symbol: ");
			String symbol = in.next();
			System.out.print("Enter number: ");
			int number = in.nextInt();
			
			if(!checkSymbol(card, symbol)) {
				count++;
			}
			
			Card c = new Card(symbol, number);
			card.add(c);
		}
		
		System.out.println("\nFour symbols gathered in " + count + " cards.");
		System.out.println("Cards in Set:");
		for(Card c: card) {
			System.out.println(c.symbol + " " + c.number);
		}
	} 
}
