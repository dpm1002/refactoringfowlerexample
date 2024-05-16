package main.java.ubu.gii;

public abstract class Prize {

	public abstract int getPriceCode();

	public abstract double getCharge(int rental);

	public int getFrequentPoint(Movie movie, int rental) {
		int frequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if ((movie.getPriceCode() == Movie.NEW_RELEASE)
				&& rental > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	

}