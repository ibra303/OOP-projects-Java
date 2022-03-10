package graph;

import java.util.*;

 public class Maze implements GraphInterface<Place>  {
	 private int size;
		private String str[][];
		private Place start,end;
		private Place[][] placearr;
 // start the class 
		public Maze(int size, int startx, int starty, int endx, int endy) 
		{
			if (startx > size || starty > size || endx > size || endy > size)
				throw new IllegalArgumentException("Error! Not Valid ");
			placearr = new Place[size][size];
			this.size = size;
			str = new String[size][size];
			for (int i = 0; i < size; i++) 
				for (int j = 0; j < size; j++)
				{
					str[i][j] = ".";
					placearr[i][j] = new Place(i, j, size);
				}
			start = placearr[startx][starty];
			end = placearr[endx][endy];
			str[startx][starty] = "S";
			str[endx][endy] = "E";
		}
		
		public boolean addWall(int x, int y) 
		{
			if (x > size || y > size)//if it's out of the maze
				throw new IllegalArgumentException("Error Point is Out of Boundery");
			if (str[x][y] == "@")
				return false;
			str[x][y] = "@";
			placearr[x][y] = null;
			return true;
		}
		public String toString()
		{
			String str1 = "";
			for (int i = 0; i < str.length; i++) 
			{
				for (int j = 0; j < str.length; j++)
				{
					if (str[i][j] == ".")
						str1 = str1 + ".";
					else
						str1 = str1 + str[i][j];
				}
				str1 = str1 + "\n";
			}
			return str1;
		}
//
		private void Build(Graph<Place> graph) throws GraphException 
		{
			for (int i = 0; i < size; i++) 
				for (int j = 0; j < size; j++) 
					if (placearr[i][j] != null && (!str[i][j].equals("@")))
						graph.addVertex(placearr[i][j]);
		}
		//
		private void AddNeighbors(Graph<Place> graph, int x1, int y1, int x2, int y2) throws GraphException 
		{
			if (x1 < size && x1 >= 0 && x2 < size && x2 >= 0 && y2 >= 0 && y1 < size && y1 >= 0 && y2 < size)
				if (!str[x2][y2].equals("@"))
				{
					try
					{
						graph.addEdge(placearr[x1][y1], placearr[x2][y2]);
					} 
					catch (Exception e) 
					{
					}
				}
		}
		//
		//It will create Graph<place> insert the induced graph from the maze  
		//and check if it can be reached from the starting point to the end point 
		public boolean isSolvable() 
		{
			Graph<Place> graph = new Graph<>();
			try 
			{
				Build(graph);
			} 
			catch (GraphException e1) 
			{
				e1.printStackTrace();
			}
			for (int i = 0; i < size; i++) 
				for (int j = 0; j < size; j++) 
					if (!str[i][j].equals("@"))
					{
						try {
							AddNeighbors(graph, i, j, i - 1, j);
						} 
						catch (GraphException e) 
						{
							e.printStackTrace();
						}
						try 
						{
							AddNeighbors(graph, i, j, i + 1, j);
						} 
						catch (GraphException e1)
						{
							e1.printStackTrace();
						}
						try 
						{
							AddNeighbors(graph, i, j, i, j + 1);
						} catch (GraphException e) 
						{
							e.printStackTrace();
						}
					}
			try 
			{
				return graph.connected(start, end);
			} 
			catch (GraphException e) 
			{
				e.printStackTrace();
			}
			return false;
		}
		//
		private void AddNeighbors(int x, int y, HashSet<Place> set)
		{
			if (x < size && x >= 0 && y < size && y >= 0)
				if (!str[x][y].equals("@"))
					set.add(placearr[x][y]);
		}
		//
		@Override
		public Collection<Place> neighbours(Place p) 
		{//for each place returns the neighbours
			if (p == null)
				return null;
			HashSet<Place> p2 = new HashSet<>();
			int x1 = p.getX(), y1 = p.getY();
			if (placearr == null) 
				for (int i = 0; i < size; i++) 
					for (int j = 0; j < size; j++) 
					{
						Place p1 = new Place(i, j, size);
						placearr[i][j] = p1;
					}
			AddNeighbors(x1 - 1, y1, p2);
			AddNeighbors(x1 + 1, y1, p2);
			AddNeighbors(x1, y1 + 1, p2);
			return p2;
		}	
		
}
