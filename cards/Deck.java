package cards;

public class Deck 
{

	private Card[] cards;
	private int CardsNum=0;


	public Deck(int num) // constructor 1
	{
		int M=0;
		
		this.cards=new Card[num*4];
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<4;j++)
			{
				this.cards[M]=new Card(i,j);
				M++;
				this.CardsNum++;
			}	
		}
	}
	
	public Deck(Deck from, int num)// constructor 2
	{
		if(num>from.CardsNum)
			num=from.CardsNum;
		
		this.cards=new Card[num];
		for(int i=0;i<num;i++)
		{
			this.cards[i]=from.cards[from.CardsNum-i-1];
			this.CardsNum++;
			
		}
		from.CardsNum=from.CardsNum-num;
	}
	

	public Deck(Deck first, Deck second) // constructor 3
	{

		int i=0;
		int M;
		M=first.CardsNum+second.CardsNum;
		this.cards=new Card[M];
		while(i<M)
		{
			if(first.CardsNum>0)
			{
				this.cards[i]=first.cards[first.CardsNum-1];
				first.CardsNum--;
				this.CardsNum++;
				i++;
			}
			if(second.CardsNum>0)
			{
				this.cards[i]=second.cards[second.CardsNum-1];
				second.CardsNum--;
				this.CardsNum++;
				i++;
			}
			
		}
	}
	
		public int getNumCards() // return the num of the cards
		{
			return this.CardsNum;
		}


		public Card takeOne() // take card from the deck 
		{
			
			if(this.CardsNum==0)return null;
			
				this.CardsNum--;
				return this.cards[this.CardsNum];
				
			
		}


		public String toString() {// this function returns all the card that on the deck as string
			if (cards[0] == null)
				return "[]";
			String str = "[";
			for (int i = 0; i < CardsNum; i++)
				str = str + cards[i].toString() + ", ";
			int end = str.length() - 2;
			str = str.substring(0, end) + "]";
			return str;
		}
		
	
		public void sort() // sort the card in the deck 
		{
			int i,j;
			Card c;
			for(i=0;i<this.CardsNum;i++)
			{
				for(j=0;j<this.CardsNum;j++)
				{
					
					if(this.cards[i].compareTo(this.cards[j])<0)
					{
						c=this.cards[j];
						this.cards[j]=this.cards[i];
						this.cards[i]=c;
						
					}
						
				}
				
			}
			
		}


}