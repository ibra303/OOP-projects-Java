package game;


public class FourInARow extends Game {
	public FourInARow(String player1, String player2)
	{
		super(6,7,new Player (player1,'W'),new Player(player2,'B'));

	}
	
	protected boolean doesWin(int i, int j)//if the line length is 4
	{
		if(maxLineContaining(i,j)==4) return true;
		return false;
	}
	
	protected boolean onePlay(Player p) 
	{//put one ball in the column which the player choose where there's place
		int i,j,x=1,y;//
		if(isFull()) return false;
		while (x==1)
		{
			i=5;  //starting from the bottom in every column
			y=1;
			System.out.println(p.toString()+", please enter column: ");
			j=s.nextInt();
			while(y==1) 
			{
				if(super.set(i, j, p)) 
				{
					System.out.println(super.toString());
					if (doesWin(i,j)) 
						return true;
					x=0;
					y=0;
				}
				else i--;//continue to check if we can put in other place

				if(i<0)// to stop the while
					y=0;
			}
		}
		return false;
	}
	
	
	
	
	
}
	
	

 