package cities;

public class City implements Comparable<City>
{
private String name;
private Country country;
private int population;
public City(String name, Country country, int population) {
	this.name = name;
	this.country = country;
	this.population = population;
}
//
public String getName() {
	return name;
}
//
public Country getCountry() {
return country;
}
public int getPopulation() {
	return population;
}
public String toString() {
	return name+" (of "+country+")";
}

@Override
public int compareTo(City other) 
{
	if(country.toString().compareTo(other.country.toString()) == 0)
		return name.compareTo(other.getName());
	return country.toString().compareTo(other.country.toString());
}

@Override

public boolean equals(Object obj)
{
	City c = (City)obj;
	if(c.country.equals(this.country)&&c.getName()==this.getName())
		return true;
	return false;
}
}
