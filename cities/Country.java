package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public class Country implements Comparable<Country>
{ 
	private String name;
	private Set<City> cities = new TreeSet<City>();	//
	public Country(String name) {
		this.name=name;
	}
	//
	public void addCity(City city) {
		//adds new city to the country
				if (!(this.name.equals(city.getCountry().name)))
					throw new IllegalArgumentException();
				if (!cities.contains(city))
					cities.add(city);
	}
	//
	
	public int population() {
		//returns the sum of population of all cities in the country
				int sum = 0;
				for (City c : cities)
					sum += c.getPopulation();
				return sum;
	}
	//
	public String toString()
	{
		return name;
	}
	public List<City> smallCities(int under)
	{//returns the list with cities that have population under the number "under"
		int i = 0;
		List<City> lowercities = new ArrayList<>();
		for (City c : cities)
		{
				while (i < lowercities.size() && c.compareTo(lowercities.get(i)) >= 0)
		            i++;
				if (c.getPopulation() < under)
					lowercities.add(i, c);
		}
		return lowercities;
	}
	
	
	public String report() 
	{
		//returns string with all the information of the country
		StringBuilder str = new StringBuilder (name + "(" + population() + ") : ");
		for (City c : cities)
			str.append(c.getName() + "(" + c.getPopulation() + "), ");
		str=str.deleteCharAt(str.length()-1);
		str=str.deleteCharAt(str.length()-1);
		return str.toString();		
	}
	
	public int compareTo(Country c)
	{
		return name.compareTo(c.toString());
	}
	//
	private boolean equals(Country other) 
	{
		return name.equals(other.toString());
	}
	

}
