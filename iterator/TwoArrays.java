package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> 
{//in the first call of next returns the first value in a1 and the next time it returns the value of the first value in a2 etc..
	private int[] a1, a2;
	private boolean bool1, bool2;

	public TwoArrays(int[] a1, int[] a2)
	{
		this.a1 = a1;
		this.a2 = a2;
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new teiterator();
	}

	private class teiterator implements Iterator<Integer>
	{
		private int count = 0, a = 1;
									
		@Override
		public boolean hasNext()
		{
			if (count < a1.length && count < a2.length)
			{ 											
				bool1 = true;
				bool2 = true;
				return true;
			} 
			else if (count < a1.length && count >= a2.length) 
			{ 													
				bool1 = true;
				bool2 = false;
				return true;
			}
			else if (count >= a1.length && count < a2.length) 
			{
				bool1 = false;
				bool2 = true;
				return true;
			}
			return false;
		}

		@Override
		public Integer next() 
		{
		if (hasNext())
			{
				if (bool1)
				{
					if (bool2) 
					{
						if (a == 1) 
						{ 			
							a = 2;
							return a1[count];
						} 
						else
						{
							a = 1;
							return a2[count++];
						}
					}
					return a1[count++];
				}
				if (bool2)
					return a2[count++];
			}
			return null;
		}
	}
}