package main.java.ubu.gii;

public class ChildrenPrize extends Prize{

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return Movie.CHILDRENS;
	}

	public double getCharge(int rental) {
		double thisAmount=1.5;
		if (rental > 3) {
			thisAmount += (rental - 3) * 1.5;
		}
		return thisAmount;
	}

}
