package main.java.ubu.gii;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	
	static int CHILDRENS = 2;
	static int REGULAR = 0;
	static int NEW_RELEASE = 1;
	
	private String _title;
	private Prize _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);;
	}

	public int getPriceCode() {
		return _priceCode.getPriceCode();
	}

	public void setPriceCode(int arg) {
		if(arg==REGULAR) {
			_priceCode=new RegularPrize();
		}else if(arg==CHILDRENS){
			_priceCode=new ChildrenPrize();
		}else {
			_priceCode=new NewReleasePrize();
		}
	}

	public String getTitle() {
		return _title;
	}

	
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

	public int getFrequentPoint(Rental rental) {
		int frequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == NEW_RELEASE)
				&& rental.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}