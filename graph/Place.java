package graph;

public class Place {
 private int  x,y,bound;
 
 public Place(int x, int y, int bound) {
	 if(x<0||y<0)
			throw new IllegalArgumentException ("Error !");
		if((x>bound-1)||(y>bound-1))
			throw new IllegalArgumentException ("Error !");
		this.x=x;
		this.y=y;
	}
 public int getX() {
	 return x;
 }
 public int getY() {
	 return y;
 }
 @Override
	public int hashCode() {
		final int now = 31;
		int finaly = 1;
		finaly = now * finaly + x;
		finaly = now * finaly + y;
		return finaly;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
