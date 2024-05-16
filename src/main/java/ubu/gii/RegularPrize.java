package main.java.ubu.gii;

public class RegularPrize extends Prize{

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return Movie.REGULAR;
	}

	public double getCharge(int rental) {
		
		double thisAmount = 2;
		if (rental > 2)
			thisAmount += (rental - 2) * 1.5;
			
		return thisAmount;
	}

}
