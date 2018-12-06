package fr.videoclub;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSuite {

    Customer johnDoe;

    @Before
    public void setUp() throws Exception {

        //Create a bunch of movies
        List<String> movieTitles = Arrays.asList("Les bronzes font du ski", "Ca tourne à Manhatan",
                "Les tontons flingueurs", "High Fidelity", "Two days in Paris", "Tous les soleils",
                "Les émotifs anonymes", "Le nom des gens", "Cars");
        Category[] priceCodes = {Category.REGULAR, Category.REGULAR, Category.REGULAR,
                Category.REGULAR, Category.REGULAR, Category.NEW_RELEASE, Category.NEW_RELEASE,
                Category.NEW_RELEASE, Category.REGULAR, Category.CHILDREN};

        List<Movie> movies = new ArrayList<>();

        int i = 0;
        for (String title : movieTitles) {
            movies.add(new Movie(title, priceCodes[i++]));
        }

        //Create a customer
        johnDoe = new Customer("John Doe");

        //Create rentals
        int nbExtraDays = 0;
        for (Movie movie : movies) {
            int nbDays = 2 + nbExtraDays;
            johnDoe.addRental(new Rental(movie, nbDays));
            nbExtraDays = (nbExtraDays + 1) % 3;
        }


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        String res = "Rental Record for John Doe" + "\n\t" + "Les bronzes font du ski	2.0" + "\n\t" + "Ca tourne à Manhatan	3.5"
                + "\n\t" + "Les tontons flingueurs	5.0" + "\n\t" + "High Fidelity	2.0" + "\n\t" + "Two days in Paris	3.5"
                + "\n\t" + "Tous les soleils	12.0" + "\n\t" + "Les émotifs anonymes	6.0" + "\n\t" + "Le nom des gens	9.0"
                + "\n\t" + "Cars	5.0" + "\n" + "Amount owed is 48.0" + "\n" + "You earned 12 frequent renter points";
        assertEquals("Statement broken", res, johnDoe.textStatement());
    }

    private void initialStatementPrinting() throws Exception {
        setUp();
        System.out.println(johnDoe.textStatement());
        System.out.println(johnDoe.htmlStatement());
    }

    public static void main(String[] args) throws Exception {
        new TestSuite().initialStatementPrinting();
    }

    @Test
    public void testHtml() {
        String expectedHtml = "<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\"><H1>Rentals for <EM>John Doe</EM></ H1><P>\n" +
                "Les bronzes font du ski: 2.0<BR>\n" +
                "Ca tourne à Manhatan: 3.5<BR>\n" +
                "Les tontons flingueurs: 5.0<BR>\n" +
                "High Fidelity: 2.0<BR>\n" +
                "Two days in Paris: 3.5<BR>\n" +
                "Tous les soleils: 12.0<BR>\n" +
                "Les émotifs anonymes: 6.0<BR>\n" +
                "Le nom des gens: 9.0<BR>\n" +
                "Cars: 5.0<BR>\n" +
                "<P>You owe <EM>48.0</EM><P>\n" +
                "On this rental you earned <EM>12</EM> frequent renter points<P>";
        assertEquals("Html Statement Broken", expectedHtml, johnDoe.htmlStatement());
    }
}
