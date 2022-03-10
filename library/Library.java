package library;

public class Library 
{
	private Book[] lib;
	public Library(int size)
	{
		 lib=new Book[size];
	}
	public void setBook(int bookNum, String title, Author auth) 
	{
		lib[bookNum]= new Book(title,auth);
	}
	
	public Book getBook(int bookNum) 
	{
		return lib[bookNum];
		
	}
}

