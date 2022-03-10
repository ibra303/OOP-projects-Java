package root;

public class Rooter {//The class will have a private double type variable called precision.
	private double precision;

	public Rooter(double precision) {//Initializes the class with a certain level of accuracy
		this.precision=precision;
	}

	public void setPrecision(double precision) {//Determines the accuracy level.
		this.precision=precision;
	}
	
	public double sqrt(double x) { //Calculation
		double one,two ;
		one=x/2.0;
		two=x/one;
		while(one!=two)
		{
			if((one-two<precision)&&(two-one<precision))
				return one;
			else {
				one=(one+two)/2.0;
				two=x/one; 
				}
		}
		return one;
	}

}