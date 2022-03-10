package bank;

public class Account {

	private String name;
	private int budget;
	// this is constructor for account class
	public Account(String name) {
		this.name=name;
		this.budget=0;
	}
	
	//return the amount of shekels the acc have
	public int getShekels() {return budget;}
	
	// return the name of the acc
	public String getName() { return name;}
	
	// add amount to the account 
	public void add(int amount) {  this.budget += amount;}
	
	//return string with all info for the account 
	public String toString() { return name +" has "+budget+" shekels";}
	}
