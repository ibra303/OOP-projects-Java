package cities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
public class World {

	private Map<String, Country> countries = new HashMap<String, Country>();

	public void addCountry(String name) 
	{
		countries.put(name, new Country(name));
	}
//add city to the world
	public void addCity(String name, String countryName, int population) 
	{
		countries.get(countryName).addCity(new City(name, countries.get(countryName), population));
	}
   //sum of all the populations in all the countries = population of the world
	public int population() 
	{
		int sum = 0;
		for (Country c : countries.values()) 
			sum += c.population();
		return sum;
	}

	public List<City> smallCities(int under) 
	{
		List<City> cities = new ArrayList<>();
		

		for (Country c : countries.values())
			cities.addAll(c.smallCities(under));
		return cities;
	}

	public String report() 
	{
		String str = "";

		for (Country c : countries.values())
			str += c.report() + "\n";
		str += "Total population is " + population() + "\n";

		return str;
	}
}