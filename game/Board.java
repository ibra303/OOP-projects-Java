package game;

public class Board {
	protected int n,m;
	protected Player[][] board ;
	
	// board constructor  
	public Board(int n, int m) 
	{
		board=new Player [n][m];
		this.n=n;
		this.m=m;
	}
	protected boolean set(int i, int j, Player p)//put the player p in board[i][j] if there's space
	{
		if(isEmpty(i,j)==true)//check if the board[i][j] is empty
		{
			board[i][j]=p;
			return true;
		}
		else
		return false;
	}
	public boolean isEmpty(int i, int j)//check if the board[i][j] is empty return true 
	{
		if(board[i][j]==null)
			return true;
		else return false;

	}
	public Player get(int i, int j)//returning the player in the place board[i][j]
	{
		Player play;
		if(isEmpty(i,j)==true) return null;
		play=board[i][j];
		return play;
	}
	public boolean isFull()//check if the board is full
	{
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				if(isEmpty(i,j)==true) return false;
			}
		return true;
	}
	public String toString() 
	{
        String str="";
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				if(isEmpty(i,j)==false)
					str+=board[i][j].getMark();
				else str+=".";
				if(j==m-1)
                    str+="\n";
			}
		return str;
	}

	protected int maxLineContaining(int i, int j)//using ray length to find the max line in the 8 directions by sum of each 2 faced directions +1 
	
	{
		int[] max=new int [4];//array to find max
		int maximum=0;//max line to return
		if(isEmpty(i,j)) return 0;
		int a=-1;//first -1 to find length of lines (-1,-1) (-1,0) (-1,1) +their faced direction +1
		int b;
		int size=0;//size of max array
			for( b=-1;b<=1;b++)
			{
				max[size]=rayLength(i,j,a,b)+rayLength(i,j,-1*a,-1*b)+1;//(-1,-1) (-1,0) (-1,1)+their faced direction +1 =line length
				size++;
			}
			 a=0;
			 b=-1;
			 max[size]=rayLength(i,j,a,b)+rayLength(i,j,-1*a,-1*b)+1;//(0,-1) +(0,1)+1 up and down and (i,j)
				size++;
				for(int z=0;z<4;z++)
					if(max[z]>maximum) maximum=max[z];//find the max and return
				return maximum;	
	}
	private int rayLength(int x, int y, int dx, int dy)
	{//find the length of the line in the direction dx ,dy without the (x,y)
		char ch=board[x][y].getMark();
int b=1;//to quit the while if we find something not equal
		int counter=0;
		x+=dx;//move x and y by dx and dy
		y+=dy;
		while(x<n && x>=0 && y<m && y>=0 && b==1 )//still in the board space
		{
			if(!isEmpty(x,y))
			if(board[x][y].getMark()==ch)counter ++;
			else b=0;//to quit while no need to continue
			x+=dx;//move again and again until we are out of the board space
			y+=dy;
		}
		return counter;
	}
	
}
	
	
	
	
	
	