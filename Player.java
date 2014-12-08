public class Player
{
	private ArrayList<Card> hand;// represents the cards a player has in his/her hand 
	private int score; // This is the number that represents the amount of tricks won and can only be added onto
	private String name; // the name a player has input to represent themselves
	private boolean inGame; //if a player is still in the game, this value is true, if they are eliminated it is false
	public Player(String n) //Constructs a player with name n 
	{
		name = n; 
	}

	public Card deal()// Returns the bottom card from hand and deletes it
	{
		Card playedCard = hand.get(hand.size()-1)
		hand.remove(hand.size()-1)
		return playedCard;
	}
	public Card deal(int n)// Returns the bottom n cards from hand and deletes them
	{
		
	}
	public void addToHand(Card c)//adds one card c to the top of the hand
	{
		hand.add(0,c);
	}
	public String displayHand() // prints the contents of hand in an asthetically pleasing way
	{
		
	}
	public int getNumCards()// returns the number of cards in hand
	{
		return hand.size();
	}
	public boolean getInGame()// returns inGame
	{
		return inGame;
	}
	public int getScore()// returns score
	{
		return score; 
	}
	public String getName()// returns name
	{
		return name; 
	}
}
