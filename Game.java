import java.util.*;

public class Game
{
	private int numPlayers; //number of players in the game
	private ArrayList<Player> players; //a list of all the players in the game
	private ArrayList<Card> compared; //the cards that are on the table for each trick and are compared
	private ArrayList<Card> pool; //the cards that are not compared in a game of war but are still won
	
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
		
	}
	public void war()
	{
		
	}
	public void addPlayer(Player a)
	{
		
	}
}
