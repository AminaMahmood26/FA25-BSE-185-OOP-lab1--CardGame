class Player{
	String name;
	int score;
	Card hand;
	Player(String name){
	  this.name=name;
 	  score = 0;
	}
   public void drawCard(Deck deck){
	  hand = deck.drawCard();
	}
   public String toString(){
	return String.format("%s %d", name,score);
	}
}