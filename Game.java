import java.util.*;

public class Game
{
	private int numPlayers; //number of players in the game
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
		int index = 0;
		for(int h=0;h<c.size()-1;h++)
		{
			if(c.get(index).getPoints()<=c.get(h).getPoints())
				index=h;
		}
		if(!isTie())
			return index;
		else 
			war();
			
	}
	public boolean isTie
}
