import java.util.*;

public class Game
{
	private int numPlayers; //number of players in the game
	private	int index; //the index with the highest valued Card
	private ArrayList<Player> players; //a list of all the players in the game
	private ArrayList<Card> compared; //the cards that are on the table for each trick and are compared
	private ArrayList<Card> pot; //the cards that are not compared in a game of war but are still won
	
	public Game()
	{
		
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
		for(int h = 0; h<players.size();h++)
		{
			compared.add(players.get(h).deal());
		}
		
//winner wins cards in pot
	}
	public void war()
	{
		
	}
	public void addPlayer(Player a)
	{
		
	}
	public int compare(ArrayList<Card> c)
	{
		index = 0;
		for(int h=0;h<c.size()-1;h++)
		{
			if(c.get(index).getPoints()<=c.get(h).getPoints())
				index=h;
		}
		if(isTie()!=true)
			return index;
		else 
			war();
			
	}
	public boolean isTie()
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
}
