package cities;

public class Road {
	private int length;
	private City c1,c2;
	public Road(City city1, City city2, int length)	{//A constructor that initializes the road as usual, but also adds the road created to both cities1 and city2. He will do this with the help of City's connect method.
		this.c1=city1;
		this.c2=city2;
		this.length=length;
		city1.connect(this);
		city2.connect(this);
	}
	public City getCity1() 
	{//Returns the first city.

		return c1;
	}
	public City getCity2()
	{//Returns the second city.
	return c2;
	}
	public int getLength() {//Returns the length of the road.
	return this.length;	
	}
}


