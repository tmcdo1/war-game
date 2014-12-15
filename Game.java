iimport java.util.*;

public class Game
{
	private int numPlayers; //number of players in the game
	private	int index; //the index with the highest valued Card
	private ArrayList<Player> players; //a list of all the players in the game
	private ArrayList<Card> compared; //the cards that are on the table for each trick and are compared
	private ArrayList<Card> pot; //the cards that are not compared in a game of war but are still won
	private Scanner input = new Scanner(System.in);//creates a Scanner object for user input
	private Deck normalDeck;

	public Game()
	{
System.out.println(" _    _            _ ");
System.out.println("| |  | |          | |");
System.out.println("| |  | | __ _ _ __| |");
System.out.println("| |/\\| |/ _` | '__| |");
System.out.println("\\  /\\  / (_| | |  |_|");
System.out.println(" \\/  \\/ \\__,_|_|  (_)");
System.out.println();
System.out.println("Welcome to the Game of War");
	players = new ArrayList<Player>();
	pot = new ArrayList<Card>();
	compared = new ArrayList<Card>();
	normalDeck = new Deck();
	}
	public boolean gameOver()
	{
		if(players.size()<=1)
			return true;
		else
			return false;
	}
	public void trick()
	{
		index=0;
		Card x;
		for(int h = 0; h<players.size();h++)
		{
			x=players.get(h).deal();
			if(x!=null)
				compared.add(x);
			else
			{
				System.out.println();
				System.out.println(players.get(h).getName()+" has been eliminated!");
				System.out.println();
				players.remove(h);
				h--;
			}
		}
//display the cards in the compare ArrayList
		displayTable(compared);

//checks to see if players are out of cards and removes them if they are
		for(int h = 0; h<players.size();h++)
		{
			if(players.get(h).isEmpty())
			{
				System.out.println();
				System.out.println(players.get(h).getName()+" has been eliminated!");
				System.out.println();
				players.remove(h);
			}

		}
		index = compare(compared);
//Checks to see if the game is over
		if(players.size()==1)
			return;

//Prints who won the trick
		System.out.println("The winner of the trick is ---> "+getTrickWinner().getName());
		System.out.println();
//winner wins cards in pot if there is a pot
		if(pot.size()!=0)
			for(int h = pot.size()-1; h>=0;h--)
			{
				players.get(index).addToHand(pot.get(h));
				pot.remove(h);
			}
//winner wins the cards on the table
		for(int h = compared.size()-1; h>=0;h--)
		{
			players.get(index).addToHand(compared.get(h));
			compared.remove(h);
		}


//displays the hand for each player
		for(int h = 0; h<players.size();h++)
		{
			System.out.print(players.get(h).getName()+"'s hand: ");
			players.get(h).displayHand();
			System.out.println("Strength of "+strength(players.get(h)));
		}
		//waits for the user to respond
		System.out.println();
		System.out.println("Please press <Enter> to continue");
		String dummy = input.nextLine();
	}
	private void war() //runs when there is a tie in high value cards
	{

		for(int h = compared.size()-1; h>=0;h--) //takes existing ArrayList<Card> compared and puts those Cards in the pot ArrayList
		{
			pot.add(compared.get(h));
			compared.remove(h);
		}
		Card x;
		for(int i = 0; i<3;i++) //players deal cards and it adds to the pot
			for(int h = 0; h<players.size();h++)
			{
				x=players.get(h).deal();
				if(x!=null)
					pot.add(x);
				else
				{
					System.out.println();
					System.out.println(players.get(h).getName()+" has been eliminated!");
					System.out.println();
					players.remove(h);
					h--;
				}
			}
		for(int h = 0; h<players.size();h++) //players deal and add cards to the compared
		{
			x=players.get(h).deal();
			if(x!=null)
				compared.add(x);
			else
			{
				System.out.println();
				System.out.println(players.get(h).getName()+" has been eliminated!");
				System.out.println();
				players.remove(h);
				h--;
			}
		}
//
		for(int h = 0; h<players.size();h++)
		{
			System.out.print(players.get(h).getName()+"'s hand: ");
			players.get(h).displayHand();
			System.out.println("Strength of "+strength(players.get(h)));
		}
//
		displayTable(compared);
		index = compare(compared);

	}
	public void addPlayer(Player a) //adds a player to the players ArrayList
	{
		players.add(a);
	}
	public int compare(ArrayList<Card> c) //compares the cards in the compared ArrayList and returns the index of the highest card. Calls on war()
	{
		index = 0;
		for(int h=0;h<c.size();h++)
		{
			if(c.get(index).getPoints()<=c.get(h).getPoints())
				index=h;
		}
		if(isTie(c,index) == false)
		{

			return index;
		}
		else
		{
			index=0;
			System.out.println("Prepare for war");
			System.out.println();
			war();

			return index;
		}



	}
	public boolean isTie(ArrayList<Card> c, int y) //checks to see if there is a tie in high values
	{

		int x = 0;
		for(int h=0;h<c.size();h++)
		{
			if(y!=h)
				if(c.get(y).getPoints()==c.get(h).getPoints())
				{
						x++;
				}
		}
		if(x>=1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private void displayTable(ArrayList<Card> c)//displays cards in the compared ArrayList()
	{
		for(int h=0;h<players.size();h++)
		{
			System.out.println(players.get(h).getName());
			String[] lines = c.get(h).getAsciiLines();
			for(int i =0;i<lines.length;i++)
				System.out.println(lines[i]);
			System.out.println();
		}
		System.out.println("Please press <Enter> to continue");
		String dummy = input.nextLine();

	}
	public Player getWinner()
	{
		return players.get(0);
	}

	public Deck getDeck()
	{
		return normalDeck;
	}
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	public Player getTrickWinner()
	{
		return players.get(index);
	}

	public int strength(Player p)
	{
		int strength = 0;
		for(int n=0; n<p.getHand().size(); n++)
		{
			strength+=p.getHand().get(n).getPoints();
		}
		return strength;
	}
}
