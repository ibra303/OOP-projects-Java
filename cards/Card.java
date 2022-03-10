package cards;

public class Card
{
	private int num;
	private int suit;
	public Card(int num, int suit) // constructor
	{
		this.num=num;
		this.suit=suit;
	}


	public int getNum() // return the num of the card
	{
	return this.num;
	}


	public int getSuit() //return the suit of the card
	{
		return this.suit;
	}
	
	public String toString() //Returns the num and suit data as a string
	{
		String str="";
		str+= this.num;
		if(this.suit==0) str+="C";
		if(this.suit==1) str+="D";
		if(this.suit==2) str+="H";
		if(this.suit==3) str+="S";
		return str;
	}

	public int compareTo(Card other) // compare 2 cards by thier strings 
	{
			return this.toString().compareTo(other.toString());
	}


}