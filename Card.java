// Compiler-tested
// Silas-approved
public class Card
{
  private int suitVal; //0-3 value, with spades, clubs, hearts, and diamonds respectively
  private int value; // 0-51 represents the unique card
  private int rankVal; //0-12 from ace to king respectively
  private int points; // 2-13 from two to ace respectively
  private String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
  private String[] suits = {"Spades","Clubs","Hearts","Diamonds"};
  private String rankStr; // the string that shows the card’s rank in a word
  private String suitStr; // the string that shows the card’s suit in a word
  private String[] asciiLines = new String[6];//The string lines that when printed together on top of each other
                                              //produce the ascii representation of the card

  public Card (int val) // contructs a card with value val
  {
    value = val;
    rankVal = value%13;
    suitVal = value/13;
    if (rankVal!=0)
      points = rankVal+1;
    else
      points = 14;
    rankStr = ranks[rankVal];
    suitStr = suits[suitVal];
    setAsciiLines();
  }
  private void setAsciiLines() // sets up the lines of Ascii art to visualy represent a card, showing rank and suit
  {
	String s = rankStr;
 	if(!s.equals("10"))
		s = rankStr.substring(0,1);

    asciiLines[0] = ".------.";
    asciiLines[1] = "|"+s+".--. |";
    if (suitVal==0) //If the card is a spade
      {
      asciiLines[2] = "| :/\\: |";
      asciiLines[3] = "| (__) |";
      }
     if (suitVal==1) //If the card is a club
      {
      asciiLines[2] = "| :(): |";
      asciiLines[3] = "| ()() |";
      }
    if (suitVal==2) //If the card is a heart
      {
      asciiLines[2] = "| (\\/) |";
      asciiLines[3] = "| :\\/: |";
      }
    if (suitVal==3) //If the card is a diamond
      {
      asciiLines[2] = "| :/\\: |";
      asciiLines[3] = "| :\\/: |";
      }
    asciiLines[4] = "| '--'"+s+"|";
    asciiLines[5] = "`------'";
  }
  public String toString() //returns a string representation of a card, with points, rank, and suit
                   //seperate from the ascii-art represenation
  {
   // String toString = rankStr+" of "+suitStr+", worth "+points+" points";
   String toString = rankStr;
 	if(!rankStr.equals("10"))
		toString = rankStr.substring(0,1);
    return toString;
  }
  public int getValue() //returns value
  {
    return value;
  }
  public String[] getAsciiLines() //returns asciiLines array
  {
    return asciiLines;
  }
  public int getPoints() //returns points
  {
    return points;
  }
  public String getRank() //returns rankStr
  {
    return rankStr;
  }
  public String getSuit() //returns suitStr
  {
    return suitStr;
  }
}
