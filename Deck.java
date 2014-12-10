import java.util.*;
public class Deck
{
  private ArrayList<Card> deck = new ArrayList<Card>(); //contains Card objects that make up the deck for the game
  private int numShuffles; //the number of times the deck was shuffled

  public Deck() //Creates a standard 52 card deck
  {
    for (int n=0; n<52; n++)
      deck.add(new Card(n));
	numShuffles = 0;
  }
  public Deck(int n) //Creates a deck of n 52 card decks
  {
  	for (int i=0; i<52*n; i++)
      deck.add(new Card(i%52));
	numShuffles = 0;
  }
  public void shuffle() //conducts a perfect shuffle on the deck
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
  public void shuffle(int i) //conducts n perfect shuffles on the deck
  {
	for (int n=0; n<i; n++)
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
  }
  public Card deal() //Returns the Card from the top of the deck
  {
  	return deck.get(0);
  }
}
