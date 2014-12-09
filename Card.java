public class Card
{
  private int suitVal; //0-3 value, with spades, clubs, hearts, and diamonds respectively 
  private int value; // 0-51 represents the unique card
  private int rankVal; //0-12 from ace to king respectively 
  private int points; // 2-14 from two to ace respectively
  private String rankStr; // the string that shows the card’s rank in a word
  private String suitStr; // the string that shows the card’s suit in a word
  
  public Card (int val) // contructs a card with value val
  {
    value = val;
  }
  public toString() //returns a string representation of a card, with points, rank, and suit
                   //seperate from the ascii-art represenation 
  {
    return rankStr+" of "+suitStr", worth "+points+"points";
  }
  public int getValue() //returns value
  {
    return value; 
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
