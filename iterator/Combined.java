package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E>
{//like TwoArrays
	private Iterator<E> first, second;

	public Combined(Iterable<E> first, Iterable<E> second)
	{ 
		this.first = first.iterator();
		this.second = second.iterator();
	}

	private class teiterator2 implements Iterator<E>
	{
		private int a = 1;

		@Override
		public boolean hasNext()
		{
			return first.hasNext() || second.hasNext();
		}

		@Override
		public E next()
		{
			if (first.hasNext()) 
			{
				if (second.hasNext())
				{ 					 
					if (a == 1) 
					{
						a = 2;
						return first.next();
					} 
					else
					{
						a = 1;
						return second.next();
					}
				}
				return first.next();
			} 
			else if (second.hasNext()) 
			{
				return second.next();
			}
			return null;
		}
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new teiterator2();
	}
}
