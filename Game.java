public class Game{
	Deck deck;
	Player players[];
	Game(String[] names){
		deck = new Deck();
		deck.shuffle();
		players=new Player[names.length];
		for(int i=0;i<names.length; i++){
		    players[i]= new Player(names[i]);
		}
	}

	public void playGame(){
		for(int round=1; round<=5; round++){
		   System.out.println("\nRound" + round);
		   int highest = 0;
		// players draw cards

		   for(int i = 0; i<players.length; i++){
		      players[i].drawCard(deck);
		     System.out.printf("%-10s drew %-15s%n", players[i].name, players[i].hand);
		      int value = getValue(players[i].hand);
		      if(value>highest)
		         highest=value;
		   }

	 // Show round winner(s) and update score
        System.out.print("Round winner(s): ");
        boolean first = true;
        for(int i = 0; i < players.length; i++) {
            if(getValue(players[i].hand) == highest) {
                players[i].score++;
                if(!first) System.out.print(", ");
                System.out.print(players[i].name);
                first = false;
            }
        }
        System.out.println(); // newline
    }
		 
       	  	showWinner();
	}

	int getValue(Card card){
		String r = card.getRANK();
		if(r.equals("Ace"))
		   return 14;
		if(r.equals("King"))
		   return 13;
		if(r.equals("Queen"))
		   return 12;
		if(r.equals("Jack"))
		   return 11;
		return Integer.parseInt(r);    // numbers 2-10 
	}
	void showWinner(){
		int max = 0;	
		System.out.println("\nFinal Scores");
		for(int i=0; i<players.length; i++){
		    System.out.println(players[i]);
		    if(players[i].score > max)
	  	       max=players[i].score;
	}
	System.out.println("\nWinner:");

	for(int i=0; i < players.length; i++){
	    if(players[i].score == max)
	       System.out.println(players[i].name);
	}
}
}


