package main.java.ubu.gii;

public abstract class Prize {

	public abstract int getPriceCode();

	public double getCharge(Rental rental) {
		double thisAmount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case 0:
			thisAmount += 2;
			if (rental.getDaysRented() > 2)
				thisAmount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case 1:
			thisAmount += rental.getDaysRented() * 3;
			break;
		case 2:
			thisAmount += 1.5;
			if (rental.getDaysRented() > 3)
				thisAmount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

}