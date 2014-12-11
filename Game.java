import java.util.*;

public class Game
{
	private int numPlayers; //number of players in the game
	private	int index; //the index with the highest valued Card
	private ArrayList<Player> players; //a list of all the players in the game
	private ArrayList<Card> compared; //the cards that are on the table for each trick and are compared
	private ArrayList<Card> pot; //the cards that are not compared in a game of war but are still won
	private Scanner input = new Scanner(System.in);//creates a Scanner object for user input
	
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
		Card x;
		for(int h = 0; h<players.size();h++)
		{
			x=players.get(h).deal();
			if(x!=null)
				compared.add(x);
			else
			{
				players.remove(h);
				h--;
			}			
		}
//display the cards in the compare ArrayList
		displayTable();
		
		index = compare(compared);
//winner wins cards in pot if there is a pot
		if(pot.size()!=0)
			for(int h = 0; h<pot.size();h++)
			{
				players.get(index).addToHand(pot.get(h));
			}
//winner wins the cards on the table
		for(int h = 0; h<compared.size();h++)
			players.get(index).addToHand(compared.get(h));
//checks to see if players are out of cards and removes them if they are
		for(int h = 0; h<players.size();h++)
		{
			if(players.get(h).isEmpty())
				players.remove(h);
		}
//displays the hand for each player
		for(int h = 0; h<players.size();h++)
			players.get(h).displayHand();
		//waits for the user to respond
		System.out.println("Please press <Enter> to continue");
		String dummy = input.nextLine();
	}
	private void war() //runs when there is a tie in high value cards
	{
		for(int h = 0; h<compared.size();h++) //takes existing ArrayList<Card> compared and puts those Cards in the pot ArrayList
		{
			pot.add(compared.get(0));
			compared.remove(0);
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
				players.remove(h);
				h--;
			}			
		}
		displayTable();
	}
	public void addPlayer(Player a) //adds a player to the players ArrayList
	{
		players.add(a);
	}
	public int compare(ArrayList<Card> c) //compares the cards in the compared ArrayList and returns the index of the highest card. Calls on war()
	{
		int x = 0;
		for(int h=0;h<c.size()-1;h++)
		{
			if(c.get(index).getPoints()<=c.get(h).getPoints())
				x=h;
		}
		if(isTie()!=true)
			return x;
		else 
		{
			war();
			return this.compare(compared);
		}

			
			
	}
	public boolean isTie() //checks to see if there is a tie in high values
	{
		int x = 0;
		for(int h=0;h<compared.size();h++)
		{
			if(compared.get(index)==compared.get(h))
			{
				if(index!=h)
					x=1;
			}
		}	
		if(x==1)
			return true;
		else
			return false;		
	}
	private void displayTable()//displays cards in the compared ArrayList()
	{
		for(int h=0;h<compared.size();h++)
		{
			String[] lines = compared.get(h).getAsciiLines();
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
}
