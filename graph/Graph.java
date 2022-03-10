package graph;

import java.util.*;

public class Graph<V> 
{
	private Set<V> vertices = new HashSet<V>(), tester;
	private Map<V, Set<V>> edges = new HashMap<>();

	
	public void addVertex(V v) throws GraphException 
	{//adds a vertex if it's already there throws exception
		if (vertices.contains(v))
			throw new GraphException("Error!");
		else
			vertices.add(v);
	}

	
	public void addEdge(V v1, V v2) throws GraphException 
	{//adds an edge ,throws exception if the edge is already there
		if (!vertices.contains(v1))
			throw new GraphException("Error v1 is not in graph!");
		if (!vertices.contains(v2))
			throw new GraphException("Error v2 is not in graph!");
		if (hasEdge(v1, v2))
			throw new GraphException("Edge is already there");
		if (!v1.equals(v2)) {
			if (edges.get(v1) == null)
				edges.put(v1, new HashSet<V>());
			edges.get(v1).add(v2);
			if (edges.get(v2) == null)
				edges.put(v2, new HashSet<V>());
			edges.get(v2).add(v1);
		}
	}


	public boolean hasEdge(V v1, V v2)
	{//check if there's an edge for v1 and v2
		if (edges.get(v1) == null || edges.get(v2) == null)
			return false;
		else if (!edges.get(v1).contains(v2) || !edges.get(v2).contains(v1))
			return false;
		return true;
	}


	public boolean connected(V v1, V v2) throws GraphException 
	{//check if we can go from v1 to v2
		
		if (!vertices.contains(v1))
			throw new GraphException("Error v1 isnt in graph");
		if (!vertices.contains(v2))
			throw new GraphException("Error v2 isnt in graph");
		tester = new HashSet<V>();
		if (tester.contains(v1))
			return false;
		tester.add(v1);
		for (V i : edges.get(v1)) 
		{
			if (i == v2)
				return true;
			if (check(i, v2) == true)
				return true;
		}
		return false;
	}	

	private boolean check(V v1, V v2) 
	{
		if (tester.contains(v1))
			return false;
		tester.add(v1);
		for (V i : edges.get(v1)) 
		{
			if (i == v2)
				return true;
			if (check(i, v2) == true)
				return true;
		}
		return false;
	}
}