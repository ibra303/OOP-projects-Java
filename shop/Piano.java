package shop;

public class Piano extends Instrument {
	
	private int octaves;
	public Piano(String company,int price, int octaves) {
		super(company,price);
		this.octaves=octaves;
	}
	public int getOctaves() {
		return octaves;
	}
	public String toString() {
		return "Piano("+getOctaves()+" octaves) "+getCompany()+"("+getSerial()+"), price = "+getPrice();
	}
}
