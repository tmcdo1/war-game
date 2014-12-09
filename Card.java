public class Card
{
  private int suitVal; 
  private int value; 
  private int rankVal; 
  private int points; 
  private String rankStr;
  private String suitStr; 
  
  public Card (int val) 
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
