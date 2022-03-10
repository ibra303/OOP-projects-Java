package mines;

import java.util.*;

public class Mines {
	private int i,j,height,width;
	private location[][] board;
	private boolean showall;
	
	public Mines(int height, int width, int numMines) 
	{
		if(numMines > height * width)
			numMines = height * width;
		this.height=height;
		this.width=width;
		this.showall = false;
		
		board=new location[height][width];
		Random rand = new Random();
		

		for(i=0 ; i< height ; i++)
		{
			for(j=0 ; j<width ; j++)
			{
				board[i][j] = new location(i,j);
			}
		}
		
		for(int k = 0; k<numMines ; k++)
		{
			i=rand.nextInt(height);
			j=rand.nextInt(width);
			if(board[i][j].ismine())
				k--;
			else 
				board[i][j].placemine();
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean addMine(int i, int j)
	{//Adds a mine in the trial location. You can assume that this method is called just after the constructor, and before all the other methods (there really is one so that tests can be done)
		if(board[i][j].ismine())
			return false;
		else {
			board[i][j].placemine();
			return true;
		}
	}
	
	public boolean open(int i, int j) {
		//Indicates that the user is opening this location. Returns true if it is not a mine. In addition, if there is no mine near this location, it opens all neighboring locations - and continues recursively.
		if(board[i][j].ismine())
			return false;
		if(board[i][j].isopenned())
			return true;
		
		board[i][j].open();
		
		boolean tmp = true;
		
		List<location> neighbors = board[i][j].getNeighbors();
	    for(location neighbor : neighbors)
	    	if(neighbor.ismine()) {
	    		tmp=false;
	    		break;
	    	}
	    
	    if(tmp) {
	    	neighbors= board[i][j].getNeighbors();
	    	for(location neighbor : neighbors)
	    		open(neighbor.getI(),neighbor.getJ());
	    }
	    
		return true;		
	}
	
	public void toggleFlag(int x, int y)
	{
		board[x][y].flag();
	}
	
	public boolean isDone() 
	{//Returns true if all non-mine locations are open.
		for(i=0;i<height;i++)	
			for(j=0;j<width;j++)		
				if(!board[i][j].ismine() && !board[i][j].isopenned())
					return false;
		
		return true;
	}
	
	public String get(int i, int j) 
	{//Returns representation as a string of the location:
		//If the position is closed, it returns "F" if it has a flag and another "."
		//If the location is open, "X" will return if it is a mine, otherwise the number of mines next to it and if this number is 0 then "".
		String str = "";
		int minecnt = 0;
		if (!board[i][j].isopenned() && !showall)
			if (board[i][j].isflag())
				str = "F";
			else
				str = ".";
		else {
			if (board[i][j].ismine())
				str = "X";
			else {
				
				List<location> neighbors = board[i][j].getNeighbors();
				for (location m : neighbors)
					minecnt += (m.ismine()) ? 1 : 0;
				if (minecnt == 0)
					str = " ";
				else
					str = "" + minecnt;

			}
		}

		return str;
	}
	
	public void setShowAll(boolean showall)
	{
		this.showall=showall;
	}
	
	public boolean winCheck()
	{
		return isDone();
	}
	
	public String toString() {
		String str = "";
		int i, j;
		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++)
				str += get(i, j);
			str += "\n";
		}
		return str;
		
	}
	
	private class location{
		private int i,j;
		private boolean mine,opened,flag;
		
		private location(int i,int j) {
			this.i=i;
			this.j=j;
			mine=opened=flag=false;
		}
		
		private void open() {
			this.opened = true;
		}
		
		private int getI() {
			return i;		
		}
		
		private int getJ() {
			return j;
		}
		
		private boolean ismine() {
			return mine;			
		}
		
		private boolean isflag() {
			return flag;
		}
		
		private boolean isopenned() {
			return opened;
		}
		
		private void placemine() {
			this.mine = !this.mine;
		}
		
		private void flag() {
			this.flag = !this.flag;
		}
		
		private List<location> getNeighbors() {
			List<location> Neighbors = new LinkedList<>();

			if (i < height - 1)
				Neighbors.add(board[i + 1][j]);
			if (j < width - 1)
				Neighbors.add(board[i][j + 1]);
			if (i > 0)
				Neighbors.add(board[i - 1][j]);
			if (j > 0)
				Neighbors.add(board[i][j - 1]);
			if (i < height - 1 && j < width - 1)
				Neighbors.add(board[i + 1][j + 1]);
			if (i > 0 && j > 0)
				Neighbors.add(board[i - 1][j - 1]);
			if (i < height - 1 && j > 0)
				Neighbors.add(board[i + 1][j - 1]);
			if (i > 0 && j < width - 1)
				Neighbors.add(board[i - 1][j + 1]);

			return Neighbors;

		}
	}
	
}
