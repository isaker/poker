import java.io.*;
import java.util.*;

public class Testpoker{

	static ArrayList<Card> deck = new ArrayList<Card>();
	static ArrayList<Card> hand = new ArrayList<Card>(2);
	static ArrayList<Card> table = new ArrayList<Card>();
	static ArrayList<Card> activeCards = new ArrayList<Card>();

	public Testpoker(){
		Deck d = new Deck(); //Add string in const and d.getDebugDeck for non shuffled deck
		//deck = d.getDeck();
		//deck = d.getStraightDeck(); //get deck preloaded with HEARTS 2-8
		//deck = d.getFourDeck(); //get deck preload with four of a kind in TWOs
		//deck = d.getFullHouseDeck(); //get deck preloaded with FULL HOUSE 222 JJ
		deck = d.getAceStraightDeck(); //get deck preloaded with HEARTS A-5
	}

	public static void deal(){
		for (int i=0;i<2 ; i++) {
		Card dealtCard = drawCard();
		hand.add(dealtCard);	
		}
	}

	public static Card drawCard(){
		Card drawnCard = deck.get(0);
		deck.remove(0);
		return drawnCard;
	}

	public static void printHand(){
		System.out.println("Cards on hand:");
		for (int i=0; i<2; i++) {
			System.out.println(hand.get(i).toString());
		}
	}

	public static void printTable(){
		System.out.println("Cards on table:");
		for (int i=0; i<table.size(); i++) {
			System.out.println(table.get(i).toString());
		}
	}

	public static void dealFlopp(){
		deck.remove(0);
		for (int i=0;i<3 ; i++) {
		Card drawnCard = drawCard();
		table.add(drawnCard);	
		}
	}

	public static void dealRiver(){
		deck.remove(0);
		Card drawnCard = drawCard();
		table.add(drawnCard);	
	}

	public static void dealTurn(){
		deck.remove(0);
		Card drawnCard = drawCard();
		table.add(drawnCard);
	}
	
	public static int handVal(){
		for (int i=0; i<2; i++) {
			activeCards.add(hand.get(i));
		}
		for (int i=0; i<table.size(); i++) {
			activeCards.add(table.get(i));
		}

		Collections.sort(activeCards);
		System.out.println("Sorted, active cards:");
		for (int i=0; i<activeCards.size(); i++) {
			System.out.println(activeCards.get(i).toString());
		}
		System.out.print("\n");

		//System.out.println(activeCards.get(0).intSuit());

		checkFlush(activeCards);
		checkFullHouse(activeCards);
		checkFourOf(activeCards);
		checkStraight(activeCards);
		checkThreeOf(activeCards);
		checkTwoPair(activeCards);
		checkPair(activeCards);
		return 0;
	}



	/*
	---methods for checking what's on hand---
	*/

	public static boolean checkPair(ArrayList<Card> cards){
		for (int i=0; i<cards.size()-1; i++) {
			if (cards.get(i).equals(cards.get(i+1))){
				System.out.println("PAIR!");
				return true;
			}
			
		}
		System.out.println("No pair");
		return false;

	}

	public static boolean checkTwoPair(ArrayList<Card> cards){
		for (int i=0; i<6; i++) {
			if (cards.get(i).equals(cards.get(i+1))){
				for (int j=i+2; j<6; j++) {
					if (cards.get(j).equals(cards.get(j+1))){
						System.out.println("TWO PAIR!");
						return true;
					}
				}
			}
			
		}
		System.out.println("No two pair");
		return false;

	}

	public static boolean checkThreeOf(ArrayList<Card> cards){
		for (int i=0; i<5; i++) {
			if (cards.get(i).equals(cards.get(i+1)) && cards.get(i).equals(cards.get(i+2))){
				System.out.println("THREE OF A KIND!");
				return true;
			}
			
		}
		System.out.println("Not three of a kind");
		return false;

	}

		public static boolean checkFourOf(ArrayList<Card> cards){
		for (int i=0; i<4; i++) {
			if (cards.get(i).equals(cards.get(i+1)) && cards.get(i).equals(cards.get(i+2)) && cards.get(i).equals(cards.get(i+3))){
				System.out.println("FOUR OF A KIND!");
				return true;
			}
			
		}
		System.out.println("Not four of a kind");
		return false;

	}

	public static boolean checkStraight(ArrayList<Card> cards){
		int cardIndex = 6;
		ArrayList<Card> playingHand1 = new ArrayList<Card>(5);
		ArrayList<Card> playingHand2 = new ArrayList<Card>(5);
		ArrayList<Card> playingHand3 = new ArrayList<Card>(5);

		ArrayList<Card> tempHand = new ArrayList<Card>(7);
		for (int i=0; i<7; i++) {
			tempHand.add(cards.get(i));
		}

		for (int i=0; i<cardIndex; i++) {
			if (tempHand.get(i).intValue()==tempHand.get(i+1).intValue()){
				tempHand.remove(i+1);
				i--;
				cardIndex--;
			}
		}	

		if(tempHand.size()<5){
			System.out.println("No straight");
			return false;
		}

		if(tempHand.size()==7){
			for (int i=0; i<tempHand.size()-2; i++) {
				playingHand1.add(tempHand.get(i));
				playingHand2.add(tempHand.get(i+1));
				playingHand3.add(tempHand.get(i+2));
			}
		}

		else if(tempHand.size()==6){
			for (int i=0; i<tempHand.size()-1; i++) {
				playingHand1.add(tempHand.get(i));
				playingHand2.add(tempHand.get(i+1));
			}
		}

		else if(tempHand.size()==5){
			for (int i=0; i<tempHand.size(); i++) {
				playingHand1.add(tempHand.get(i));
			}
		}

		System.out.println("-----Steghand 1-----");
		for (int i=0; i<playingHand1.size(); i++) {
			System.out.println(playingHand1.get(i).toString());
		}
		System.out.println('\n');

		System.out.println("-----Steghand 2-----");
		for (int i=0; i<playingHand2.size(); i++) {
			System.out.println(playingHand2.get(i).toString());
		}
		System.out.println('\n');

		System.out.println("-----Steghand 3-----");
		for (int i=0; i<playingHand3.size(); i++) {
			System.out.println(playingHand3.get(i).toString());
		}
		System.out.println('\n');



		if (playingHand1.size() == 5 && inOrder(playingHand1)){
			if(checkSameSuit(playingHand1, playingHand1.size())){
				System.out.println("STRAIGHT FLUSH!");
			}
			else System.out.println("1    STRAIGHT!");

			return true;
		}
		else if (playingHand2.size() == 5 && inOrder(playingHand2)){
			if(checkSameSuit(playingHand2, playingHand2.size())){
				System.out.println("STRAIGHT FLUSH!");
			}
			else System.out.println("2      STRAIGHT!");
			return true;
		}
		else if (playingHand3.size() == 5 && inOrder(playingHand3)){
			if(checkSameSuit(playingHand3, playingHand3.size())){
				System.out.println("STRAIGHT FLUSH!");
			}
			else System.out.println("3      STRAIGHT!");
			return true;
		}
		else if(specialStraight(tempHand)){
			ArrayList<Card> tempHandSpecial = new ArrayList<Card>(5);
		
			tempHandSpecial.add(tempHand.get(0));
			tempHandSpecial.add(tempHand.get(tempHand.size()-1));
			tempHandSpecial.add(tempHand.get(tempHand.size()-2));
			tempHandSpecial.add(tempHand.get(tempHand.size()-3));
			tempHandSpecial.add(tempHand.get(tempHand.size()-4));

			if(checkSameSuit(tempHandSpecial, 5)){
				System.out.println("STRAIGHT FLUSH!");
			}
			else System.out.println("STRAIGHT!");
			return true;
		}
		else {
			System.out.println("No straight");
			return false;
		}
	}

	public static boolean specialStraight(ArrayList<Card> cards){
		if(cards.get(0).getValue() != Value.ACE){
			return false;
		}
		else if(cards.get(cards.size()-1).intValue() == 2 &&
				cards.get(cards.size()-2).intValue() == 3 &&
				cards.get(cards.size()-3).intValue() == 4 &&
				cards.get(cards.size()-4).intValue() == 5){
			return true;
		}
		return false;
	}

	public static boolean checkFullHouse(ArrayList<Card> cards){
		ArrayList<Card> tempHand = new ArrayList<Card>(7);
		for (int i=0; i<7; i++) {
			tempHand.add(cards.get(i));
		}
		for (int i=0; i<5; i++) {
			if (tempHand.get(i).equals(tempHand.get(i+1)) && tempHand.get(i).equals(tempHand.get(i+2))){
				
				tempHand.remove(i+2);
				tempHand.remove(i+1);
				tempHand.remove(i);
								
				if (checkPair(tempHand)){
					System.out.println("FULL HOUSE!");
					return true;
				}
				else
					return false;
			}
			
		}
		System.out.println("No full house");
		return false;
	}

	public static boolean checkFlush(ArrayList<Card> cards){
		ArrayList<Card> tempHand = new ArrayList<Card>(7);
		for (int i=0; i<7; i++) {
			tempHand.add(cards.get(i));
		}
		if(checkSameSuit(tempHand, 7)){
			return true;
		}
		else {
			System.out.println("No flush");
			return false;	
		}
	}

	public static boolean checkSameSuit(ArrayList<Card> cards, int numCards){
		int hearts = 0;
		int spades = 0;
		int clubs = 0;
		int diamonds = 0;
		int suit;
		for (int i=0; i<numCards; i++) {
			suit = cards.get(i).intSuit();
			switch(suit){
				case 1: hearts++;
					break;
				case 2: diamonds++;
					break;
				case 3: clubs++;
					break;
				case 4: spades++;
					break;
			}
		}
		/*System.out.println("hearts: " + hearts);
		System.out.println("diamonds: " + diamonds);
		System.out.println("clubs: " + clubs);
		System.out.println("spades: " + spades);*/

		if(hearts>=5){
			System.out.println("FLUSH OF HEARTS");
			return true;
		}
		if(spades>=5){
			System.out.println("FLUSH OF SPADES");
			return true;
		}
		if(clubs>=5){
			System.out.println("FLUSH OF CLUBS");
			return true;
		}
		if(diamonds>=5){
			System.out.println("FLUSH OF DAMONDS");
			return true;
		}
		else 
			return false;

	}


	//Checks if the five provided cards are in order, creating a straight
	public static boolean inOrder(ArrayList<Card> cards){
		for (int i=0; i<cards.size()-1; i++) {
			if (cards.get(i).intValue()-1 != cards.get(i+1).intValue()){
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]){
		Testpoker poker = new Testpoker();
		deal();
		printHand();
		dealFlopp();
		//printTable();
		dealRiver();
		//printTable();
		dealTurn();
		printTable();
		handVal();

	}
}