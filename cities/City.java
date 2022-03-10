package cities;

public class City {
	private String name;
	private Road[] roads;
	private int numRoads=0;
	public City(String name) {
		this.name=name;
		roads=new Road[10];
		numRoads=0;
	}
	public void connect(Road r) {//Adds the road to the city's road list
		if(numRoads<10)
		roads[numRoads++]=r;
	}
	
	public City nearestCity() // return the nearest city
	{
		Road min=(roads)[0];
		if(this.roads[0]==null)
			return null;
		for(int i=0;i<numRoads;i++)
		{
			if((roads)[i].getLength()<min.getLength())
				min=(roads)[i] ;
		}
		return min.getCity2();
	}
	public String toString()
	{//Returns the city name.
		return this.name ;
	}
}
