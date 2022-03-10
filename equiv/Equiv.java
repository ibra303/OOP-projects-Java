package equiv;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class Equiv<E> 
{
	
	private Map<E, List<E>> map = new TreeMap<E, List<E>>();
	private int check = 0; //in order to check if we have to make another new list to add both e1 and e2
	
	public void add(E e1, E e2) 
	{//insert that e1 and e2 are equivalence
		check = 0;
		if (map.containsKey(e1))
		{
			List<E> l = map.get(e1);
			if (!l.contains(e2))
				l.add(e2);
			check = 1;
		}
		else if (map.containsKey(e2))
		{
				List<E> l =map.get(e2);
				if (!l.contains(e1))
					l.add(e1);
				check = 1;
		}
		for(E key : map.keySet())
		{//insert e1 to all the lists that has e2 and the opposite
			if (map.get(key).contains(e1) && (!map.get(key).contains(e2)) && !(key.equals(e2)))
			{
				map.get(key).add(e2); 
				check = 1;
			}
			if (map.get(key).contains(e2) && (!map.get(key).contains(e1)) && !(key.equals(e1)))
			{
				map.get(key).add(e1);
				check = 1;
			}
		}
		if (check == 0)
		{
			List<E> l = new ArrayList<E>();
			l.add(e2);
			map.put(e1, l);
			List<E> l2 = new ArrayList<E>();
			l2.add(e1);
			map.put(e2, l2);
		}
	}

	public boolean are(E e1, E e2)
	{//checks if e1 and e2 are equivalence
		if (e1.equals(e2))
			return true;
		
		if (map.containsKey(e1))
		{
			List<E> l = map.get(e1);
			if (l.contains(e2))
				return true;
		}
		if (map.containsKey(e2))
		{
			List<E> l = map.get(e2);
			if (l.contains(e1))
				return true;
		}
		for(E e : map.keySet())
		{
			if (map.get(e).contains(e1) && (map.get(e).contains(e2)))
				return true;
		}
		return false;
	}
}

