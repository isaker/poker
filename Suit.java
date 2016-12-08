

public enum Suit {
		HEARTS(1), DIAMONDS(2), CLUBS(3), SPADES(4);
			
		private int suit;
			
		Suit(int i){
			suit=i;
		}	

		public int getSuit(){
			return suit;
		}
}