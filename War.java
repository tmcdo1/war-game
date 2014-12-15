
import java.util.*;
public class War
{
	private static int numPlayers =0 ; //number of players
	private static String[] names = {"Grace H.","Charles B.","Alan T.","Ada L."};
	private static Scanner scanNum = new Scanner(System.in); //takes user input for numPlayers
	private static Scanner scanStr = new Scanner(System.in);//scanner for the input of a name.
	private static boolean test;

	public static void main(String[] args)
	{
		//Sets up the entire game of war
		Game w = new Game();
		System.out.println();
		while(numPlayers<2||numPlayers>5)
		{
			System.out.print("How many players would you like? (2-5) ---> ");
			numPlayers = scanNum.nextInt();
		}
		System.out.println();
		System.out.print("What would you like your gamertag to be? ---> ");
		String playerName = scanStr.nextLine();
		w.addPlayer(new Player(playerName));
		for(int h=0;h<numPlayers-1;h++)
			w.addPlayer(new Player(names[h]));
		w.getDeck().deal(w.getPlayers());

		//runs trick
		test = true;
		w.trick();
		while(test)
		{
			w.trick();
			if(w.gameOver())
				test = false;
			else
				test = true;
		}
		System.out.println();
		System.out.println("Congratulations "+w.getWinner().getName()+"!");
		System.out.println(w.getWinner().getName()+" has won the game!");
		System.out.println();
		System.out.println(" _____          _          __   _    _            ");
		System.out.println("|  ___|        | |        / _| | |  | |           ");
		System.out.println("| |__ _ __   __| |   ___ | |_  | |  | | __ _ _ __ ");
		System.out.println("|  __| '_ \\ / _` |  / _ \\|  _| | |/\\| |/ _` | '__|");
		System.out.println("| |__| | | | (_| | | (_) | |   \\  /\\  / (_| | |   ");
		System.out.println("\\____/_| |_|\\__,_|  \\___/|_|    \\/  \\/ \\__,_|_|   ");
		System.out.println();

	}
}
