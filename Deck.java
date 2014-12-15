import java.util.*;

public class Deck
{
  private ArrayList<Card> deck; //contains Card objects that make up the deck for the game
  private int numShuffles; //the number of times the deck was shuffled

  public Deck() //Creates a standard 52 card deck
  {
    deck = new ArrayList<Card>();
	for (int n=0; n<52; n++)
      deck.add(new Card(n));
	numShuffles = 0;
	shuffle(2);
  }
  public Deck(int n) //Creates a deck of n 52 card decks
  {
  	for (int i=0; i<52*n; i++)
      deck.add(new Card(i%52));
	numShuffles = 0;
  }
  public void shuffle() //conducts a random shuffle on the deck
  {
	this.shuffle(1);
  }
  public void shuffle(int i) //conducts i random shuffles on the deck
  {
/*	int deckSize = deck.size();
	for (int n=0; n<i; n++)
	{
		int x = 0;
		Card[] shuffled = new Card[deckSize];
		for(int h=0;h<deckSize/2;h++)
		{
			shuffled[x] = deck.get(h);
			x+=2;
		}
		x =1;
		for(int h=deckSize-(deckSize/2);h<deckSize;h++)
		{
			shuffled[x] = deck.get(h);
			x+=2;
		}
		for(int h=0; h<deckSize;h++)
			deck.add(shuffled[h]);
	}
*/
		int deckSize = deck.size();
		int ran;
		Card temp;
		Random randInt = new Random();
		for(int h=deckSize-1;h>0;h--)
		{
			ran = randInt.nextInt(h+1);
			temp = deck.get(ran);
			deck.set(ran,deck.get(h));
			deck.set(h,temp);
		}
  }
  public Card deal() //Returns the Card from the top of the deck
  {
  	Card c = deck.get(0);
	deck.remove(0);
	return c;
  }

	public void deal(ArrayList<Player> p)
	{
		int numDeal = 52/p.size();
		shuffle(2);
		for (int n=0; n<p.size(); n++)
			for (int i=0; i<numDeal; i++)
		{
			p.get(n).addToHand(deal());
		}
	}
}
