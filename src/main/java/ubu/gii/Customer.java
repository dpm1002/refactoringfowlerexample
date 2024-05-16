package main.java.ubu.gii;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		StringBuilder result=new StringBuilder();
		result.append("<html><head><title>Rental Record</title></head><body>");
        result.append("<h1>Rental Record for " + getName() + "</h1>");
        result.append("<table>");
        result.append("<tr><th>Title</th><th>Amount</th></tr>");
        double thisAmount = 0;
		while (rentals.hasNext()) {
			
			Rental each = rentals.next();
			thisAmount = each.getCharge();
			
			
			frequentRenterPoints += each.getFrequentPoint();
			// show figures for this rental
			result.append("<tr><td>" + each.getMovie().getTitle() + "</td><td>" + String.format("%.2f", thisAmount) + "</td></tr>");
			totalAmount += thisAmount;
		}
		// add footer lines
		result.append("</table>");
        result.append("<p>Amount owed is " + String.format("%.2f", totalAmount) + "</p>");
        result.append("<p>You earned " + frequentRenterPoints + " frequent renter points</p>");
        result.append("</body></html>");
		return result.toString();
	}

}