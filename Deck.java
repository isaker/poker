

import java.util.*;

public class Deck{

	static ArrayList<Card> startDeck = new ArrayList<Card>(52);
	static ArrayList<Card> shuffleDeck = new ArrayList<Card>(52);
	static ArrayList<Card> straightDeck = new ArrayList<Card>(7); //debug

	public Deck(){
		shuffleDeck(insertDeck());
	}
	
	public Deck(String s){
		insertDeck();
	}
	
	public static ArrayList<Card> insertDeck(){
		int i=1;
		for (Suit s : Suit.values()){
			Suit color = s;
			for (Value v : Value.values()){
				Card card = new Card(color, v);
				startDeck.add(card);
				i++;
			}

		}

		return startDeck;
	}
	
	public static ArrayList<Card> getDeck(){
		return shuffleDeck;
		
	}

	
	public static ArrayList<Card> getDebugDeck(){
		return startDeck;
		
	}

	public static void shuffleDeck(ArrayList<Card> arrayList){
		Random rand = new Random();
		int n;
		int temp = 0;
		for (int i = 52; i != 0; i--){
			n = rand.nextInt(i)+0;
			shuffleDeck.add(startDeck.get(n));
			startDeck.remove(n);

		}

	}

	//debug only 
	public static ArrayList<Card> getStraightDeck(){
		Card card1 = new Card(Suit.HEARTS, Value.TWO);
		straightDeck.add(card1);
		Card card2 = new Card(Suit.HEARTS, Value.THREE);
		straightDeck.add(card2);
		Card card3 = new Card(Suit.CLUBS, Value.THREE); //slängs på flopp
		straightDeck.add(card3);
		Card card4 = new Card(Suit.HEARTS, Value.FOUR);
		straightDeck.add(card4);
		Card card5 = new Card(Suit.HEARTS, Value.FIVE);
		straightDeck.add(card5);
		Card card6 = new Card(Suit.HEARTS, Value.SIX);
		straightDeck.add(card6);
		Card card7 = new Card(Suit.CLUBS, Value.THREE); //slängs på river
		straightDeck.add(card7);
		Card card8 = new Card(Suit.HEARTS, Value.SEVEN);
		straightDeck.add(card8);
		Card card9 = new Card(Suit.CLUBS, Value.THREE); //slängs på turn
		straightDeck.add(card9);
		Card card10 = new Card(Suit.HEARTS, Value.EIGHT);
		straightDeck.add(card10);
		return straightDeck;
		
	}

	public static ArrayList<Card> getFourDeck(){
		Card card1 = new Card(Suit.HEARTS, Value.TWO);
		straightDeck.add(card1);
		Card card2 = new Card(Suit.CLUBS, Value.TWO);
		straightDeck.add(card2);
		Card card3 = new Card(Suit.CLUBS, Value.THREE); //slängs på flopp
		straightDeck.add(card3);
		Card card4 = new Card(Suit.SPADES, Value.TWO);
		straightDeck.add(card4);
		Card card5 = new Card(Suit.DIAMONDS, Value.TWO);
		straightDeck.add(card5);
		Card card6 = new Card(Suit.HEARTS, Value.SIX);
		straightDeck.add(card6);
		Card card7 = new Card(Suit.CLUBS, Value.FOUR); //slängs på river
		straightDeck.add(card7);
		Card card8 = new Card(Suit.HEARTS, Value.SEVEN);
		straightDeck.add(card8);
		Card card9 = new Card(Suit.CLUBS, Value.FIVE); //slängs på turn
		straightDeck.add(card9);
		Card card10 = new Card(Suit.HEARTS, Value.EIGHT);
		straightDeck.add(card10);
		return straightDeck;
		
	}

	public static ArrayList<Card> getFullHouseDeck(){
		Card card1 = new Card(Suit.HEARTS, Value.TWO);
		straightDeck.add(card1);
		Card card2 = new Card(Suit.CLUBS, Value.TWO);
		straightDeck.add(card2);
		Card card3 = new Card(Suit.CLUBS, Value.THREE); //slängs på flopp
		straightDeck.add(card3);
		Card card4 = new Card(Suit.SPADES, Value.KING);
		straightDeck.add(card4);
		Card card5 = new Card(Suit.DIAMONDS, Value.TWO);
		straightDeck.add(card5);
		Card card6 = new Card(Suit.HEARTS, Value.SIX);
		straightDeck.add(card6);
		Card card7 = new Card(Suit.CLUBS, Value.FOUR); //slängs på river
		straightDeck.add(card7);
		Card card8 = new Card(Suit.HEARTS, Value.JACK);
		straightDeck.add(card8);
		Card card9 = new Card(Suit.CLUBS, Value.FIVE); //slängs på turn
		straightDeck.add(card9);
		Card card10 = new Card(Suit.SPADES, Value.JACK);
		straightDeck.add(card10);
		return straightDeck;
		
	}

	public static ArrayList<Card> getAceStraightDeck(){
		Card card1 = new Card(Suit.HEARTS, Value.TWO);
		straightDeck.add(card1);
		Card card2 = new Card(Suit.HEARTS, Value.THREE);
		straightDeck.add(card2);
		Card card3 = new Card(Suit.CLUBS, Value.THREE); //slängs på flopp
		straightDeck.add(card3);
		Card card4 = new Card(Suit.HEARTS, Value.FOUR);
		straightDeck.add(card4);
		Card card5 = new Card(Suit.HEARTS, Value.FIVE);
		straightDeck.add(card5);
		Card card6 = new Card(Suit.HEARTS, Value.ACE);
		straightDeck.add(card6);
		Card card7 = new Card(Suit.CLUBS, Value.THREE); //slängs på river
		straightDeck.add(card7);
		Card card8 = new Card(Suit.HEARTS, Value.JACK);
		straightDeck.add(card8);
		Card card9 = new Card(Suit.CLUBS, Value.THREE); //slängs på turn
		straightDeck.add(card9);
		Card card10 = new Card(Suit.HEARTS, Value.QUEEN);
		straightDeck.add(card10);
		return straightDeck;
		
	}

	public static ArrayList<Card> getStraightDeck2(){
		Card card1 = new Card(Suit.HEARTS, Value.TWO);
		straightDeck.add(card1);
		Card card2 = new Card(Suit.HEARTS, Value.THREE);
		straightDeck.add(card2);
		Card card3 = new Card(Suit.CLUBS, Value.THREE); //slängs på flopp
		straightDeck.add(card3);
		Card card4 = new Card(Suit.HEARTS, Value.FOUR);
		straightDeck.add(card4);
		Card card5 = new Card(Suit.HEARTS, Value.FIVE);
		straightDeck.add(card5);
		Card card6 = new Card(Suit.HEARTS, Value.SIX);
		straightDeck.add(card6);
		Card card7 = new Card(Suit.CLUBS, Value.THREE); //slängs på river
		straightDeck.add(card7);
		Card card8 = new Card(Suit.DIAMONDS, Value.FIVE);
		straightDeck.add(card8);
		Card card9 = new Card(Suit.CLUBS, Value.THREE); //slängs på turn
		straightDeck.add(card9);
		Card card10 = new Card(Suit.CLUBS, Value.FIVE);
		straightDeck.add(card10);
		return straightDeck;
		
	}



}