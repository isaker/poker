

public class Card implements Comparable<Card>{

	private final Suit c;
	private final Value v;

	public Suit getColor(){
		return c;
	}

	public int intSuit(){
		return c.getSuit();
	}

	public Value getValue(){
		return v;
	}

	public int intValue(){
		return v.getValue();
	}

		// CONSTRUCTOR

	public Card(Suit color, Value v){
		this.c = color;
		this.v = v;
	}

	/*
	Compare methods for comparing the Values of cards
	*/
	public int compareTo(Card c){
		Integer c1 = new Integer(this.intValue());
		Integer c2 = new Integer(c.intValue());
		return c2.compareTo(c1);
	}

	public int compare(Card c1, Card c2){
		return c2.intValue() - c1.intValue();
	}


	/*
	Compare method for comparing the Suit of cards
	*/
	public int compareSuit(Card c){
		Integer c1 = new Integer(this.intSuit());
		Integer c2 = new Integer(c.intSuit());
		return c1 - c2;
	}


	//Checks if the values of the cards are the same
	public boolean equals(Card c){
		if (this.intValue()==c.intValue()){
			return true;
		}
		else return false;
	}

	//Checks if the suits of the cards are the same
	public boolean sameSuit(Card c){
		return this.intSuit() == c.intSuit();
	}

	public String toString(){
		String value = this.getValue().toString();
		String color = this.getColor().toString();
		String tostring = value + " of " +  color;
		return tostring;
	}

		/*public boolean isGreaterThan(Card c){
			if(this.getColor().getSuit()==c.getColor().getSuit()){
				if(this.getValue().getValue() > (c.getValue()).getValue()){
					return true;
				}
			}
			return false;			
		} */
		
	}