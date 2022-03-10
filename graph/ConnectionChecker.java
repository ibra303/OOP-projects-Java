package graph;

import java.util.*;

public class ConnectionChecker<V> 
{
	private GraphInterface<V> graph;
	private Set<V> tester;

	
	public ConnectionChecker(GraphInterface<V> g) 
	{
		this.graph = g;
	}
//returns if we can go from v1 to v2
	public boolean check(V v1, V v2) 
	{
		tester = new HashSet<V>();
		return check2(v1, v2);
	}

	private boolean check2(V v1, V v2)
	{
		if (v1 == null || v2 == null)
			return false;
		if (tester.contains(v1))
			return false;
		tester.add(v1);
		if (graph.neighbours(v1) != null)
		{
			for (V i : graph.neighbours(v1)) 
			{
				if (i == null)
					return false;
				if (i.equals(v2))
					return true;
				if (!tester.contains(i)) 
				{
					if (check2(i, v2) == true)
						return true;
				}
			}
		}
		return false;
	}
}
