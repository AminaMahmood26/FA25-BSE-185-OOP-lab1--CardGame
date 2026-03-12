import java.util.Random;
public class Deck{
	Card cards[];
	private int top = 0;     // points to the next card to draw

	private String suits[]={"Spades" , "Clubs" ,"Hearts" , "Diamonds"};
	private String ranks[]={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	Deck(){
	cards=new Card[52];
	int counter=0;
	for(int i=0;i<suits.length;i++)
	 for(int j=0;j<ranks.length;j++)
	  cards[counter++]=new Card(suits[i],ranks[j]);
	}
	public void displayDeck(){
		for(Card card:cards)
		 System.out.println(card);
	}
	public void shuffle(){
	 Random random=new Random();
	 for (int i=0;i<10000;i++){
	   int tempIndex=random.nextInt(52);
	   Card temp=cards[0];
	   cards[0]=cards[tempIndex];
	   cards[tempIndex]=temp;
	  }
	}
	public Card drawCard() {
        	if (top < cards.length) {
        	    return cards[top++];    // return the next card
      	        }
        return null;               // no cards left
        }
 
}