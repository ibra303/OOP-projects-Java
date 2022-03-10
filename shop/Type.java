package shop;

public enum Type {
  ACOUSTIC{
	  public String toString() {
		  return "Acoustic" ;
	  }
  }
  ,ELECTRIC{
	  public String toString() {
		  return "Electric";
	  }
  }
  ,CLASSICAL
  {
	  public String toString() {
		  return "Classical";
	  }
  };	
}