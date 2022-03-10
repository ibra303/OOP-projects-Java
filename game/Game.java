package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in); 
	public Game(int n, int m, Player p1, Player p2)
	{
		super(n,m);
		players=new Player[2];//2 players
		players[0]=p1;
		players[1]=p2;
	}
	protected boolean doesWin(int i, int j)
	{//check if the player has won..put in 0,0
		if(i==0 && j==0) return true;
		return false;
	}
	
	protected boolean onePlay(Player p)
	{
		int x,y;
		System.out.println(p.toString()+" , please enter x and y:");
		x=s.nextInt();
		y=s.nextInt();
       while(super.set(x, y, p)==false)//if the place full amd failed to put
       {
    	   System.out.println ("There is a piece there already...");
    	   System.out.println(p.toString()+" , please enter x and y:");
			System.out.println(super.toString());
    	   x=s.nextInt();
   		   y=s.nextInt();
       }
		System.out.println(super.toString());

       if(doesWin(x,y))//if he won
			return true;
       return false;
	}
	public Player play()
	{//check who is the winner keep playing until someone win
		while(!isFull())
		{
			
			if(onePlay(players[0])==true) 
			{
				System.out.println (players[0].toString()+" Won!");
					return players[0];
			}
			if(onePlay(players[1])==true)
			{
				System.out.println (players[1].toString()+" Won!");
				return players[1];
		}	
	}
		return null;

}
}
	
	
	

