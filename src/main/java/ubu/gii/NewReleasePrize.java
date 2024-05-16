package main.java.ubu.gii;

public class NewReleasePrize extends Prize{

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return Movie.NEW_RELEASE;
	}

	public double getCharge(int rental) {
		
		return rental * 3;
		
	}

}
