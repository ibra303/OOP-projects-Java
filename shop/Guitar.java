package shop;

public class Guitar extends Instrument {
	private Type type;
	//
	public Guitar(String company, int price, Type type) {
		super(company,price);
		this.type=type;
	}
	public Type getType() {
		return type;
	}
	public String toString() {
		return "Guitar("+getType()+") "+getCompany()+"("+getSerial()+"), price = "+getPrice();
	}
	}







	
