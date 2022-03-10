package shop;
import java.util.List;
import java.util.ArrayList;

public class Shop {
	List<Instrument> l = new ArrayList<>();
	
	//adds new Instrument to the list
	public void add(Instrument i) {
	l.add(i);
}
//
public Instrument get(int serial) {
	//returns the instrument in the list which has the serial "serial"
	for(int i=0; i<l.size(); i++)
		 if(l.get(i).getSerial() == serial)
			 return l.get(i);
	 return null;
}
//returns all the serials in the shop or the list
public List<Integer> allSerials(){
	List<Integer> l1 = new ArrayList<>();
	for(int i=0; i<l.size(); i++)
		 l1.add(l.get(i).getSerial());
	 return l1;
}
//returns the serials of the guitars from the type t
public List<Integer> guitarsOfType(Type t){
	List<Integer> l2 = new ArrayList<>();
	for(Instrument i : l) {
		if(i instanceof Guitar)
			if(((Guitar)i).getType()==t)
		      	l2.add(i.getSerial());
	}
	return l2;
}
//
public void sell(int serial) throws MusicShopException{
	int count=0;
	 if(serial-1 > l.size())
			throw new MusicShopException("Sorry,error!");
	 
		for(int i=0;i<l.size();i++)
			if (l.get(i) instanceof Guitar)
				count++;
		
		Instrument l1 = this.get(serial);
		
		if (l1 instanceof Piano && l.isEmpty() == false)
			l.remove(l1);

		else if (l1 instanceof Guitar && l.isEmpty() == false && count > 1)
			l.remove(l1);
		else throw new MusicShopException("Sorry ,error!");

	
}
public int sellAll(int[] serials) {
	int count =0;
	for(int s : serials) {
		try {
			sell(s);}
		catch(MusicShopException e) {
			count++;}
	}
	return count;
}
}









