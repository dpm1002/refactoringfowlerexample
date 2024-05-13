package test.java.ubu.gii;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.ubu.gii.Customer;
import main.java.ubu.gii.Movie;
import main.java.ubu.gii.Rental;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1

 * 
 */
public class VideoClubTest {
	protected static Movie m0, m11, m12, m2;
	protected static Customer c1;
	
	@BeforeAll
	public static void setUp() {
		m11 = new Movie("Sky Captain", 1);
		m12 = new Movie("Alejandro Magno", 1);
		m0 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso", 2);

		c1 = new Customer("Manuel");
	}

	@AfterAll
	public static void tearDown() throws Exception {}

	@Test
	public void testAlquiler() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.statement();

		String expectedHtmlOutput = "<html><head><title>Rental Record</title></head><body>"
                + "<h1>Rental Record for Manuel</h1>"
                + "<table>"
                + "<tr><th>Title</th><th>Amount</th></tr>"
                + "<tr><td>Sky Captain</td><td>15,00</td></tr>"
                + "<tr><td>Accion Mutante</td><td>2,00</td></tr>"
                + "<tr><td>Hermano Oso</td><td>12,00</td></tr>"
                + "</table>"
                + "<p>Amount owed is 29,00</p>"
                + "<p>You earned 4 frequent renter points</p>"
                + "</body></html>";
		System.out.println(salida);
		System.out.println(expectedHtmlOutput);
		
		assertTrue(expectedHtmlOutput.equals(salida),"Calcula mal el alquiler");

	}

}
