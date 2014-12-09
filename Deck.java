import java.util.*;
public class Deck
{
  private ArrayList<Card> deck = new ArrayList<Card>(); //contains Card objects that make up the deck for the game
  private int numShuffles; //the number of times the deck was shuffled

  public Deck() //
  {
    for (int n=0; n<52; n++)
      deck.add(new Card(n));
	numShuffles = 0;
  }
  /*public Deck(int n) //
  {

  }*/
  public void shuffle() //
  {
	int deckSize = deck.size();
		int x = 0;
		ArrayList<Card> shuffled = new ArrayList<Card>();
		for(int h=0;h<deckSize/2;h++)
		{
			shuffled.add(x,deck.get(h));
			x+=2;
		}
		x =1;
		for(int h=deckSize-(deckSize/2);h<deckSize;h++)
		{
			shuffled.add(x,deck.get(h));
			x+=2;
		}
		for(int h=0; h<deckSize;h++)
			deck.add(shuffled.get(h));
  }
  /*public Card deal() //
  {

  } */
}
