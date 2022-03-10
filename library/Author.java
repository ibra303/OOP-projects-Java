package library;

public class Author 
{
	 private String name;
	private int birthYear;
	
	public Author(String name, int birthYear)/*The constructor*/
	{
		this.name=name;
		this.birthYear=birthYear;
	}
	
	public String getName()/* Returns the name of the author*/ 
	{
		return name;
	}
	
	public int getBirthYear()/*returns the birth year of the author*/ 
	{
		return birthYear;	
	}
	
	public int getAge(int thisYear)/*returns the age of the author*/ 
	{
		return thisYear-birthYear;
	}

	public String toString()
	{
		return name+"("+birthYear+")";
	}
}