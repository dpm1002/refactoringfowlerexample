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

	public int getFrequentPoint(int rental) {
		int frequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if ((getPriceCode() == Movie.NEW_RELEASE)
				&& rental > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

}
