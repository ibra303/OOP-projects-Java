package shop;

public abstract class Instrument {
protected String company;
protected int price;
protected static int Serial=0;//serial starts with 0
private int counter=0;//serial starts with 0
public Instrument(String company , int price){
	this.price=price;
	this.company=company;
	setSerial(Instrument.Serial);
	Instrument.Serial++;
}
public int getPrice() {
	return price;
}
public String getCompany() {
	return company;
}
public int getSerial() 
{
	return counter;
}
public void setSerial(int serial) 
{
   this.counter=Serial;
}
}

