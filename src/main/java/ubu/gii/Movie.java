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
	
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
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
		return _priceCode.getCharge(rental);
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