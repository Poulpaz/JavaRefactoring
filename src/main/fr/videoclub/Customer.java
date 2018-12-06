package fr.videoclub;

import java.util.*;

public class Customer {
    private final TextStatement textStatement = new TextStatement(this);
    private final HtmlStatement htmlStatement = new HtmlStatement(this);
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        getRentals().add(arg);
    }

    public String getName() {
        return name;
    }

    public String textStatement() {
        return new TextStatement(this).value();
    }

    public String htmlStatement() {
        return new HtmlStatement(this).value();
    }

    double getTotalCharges() {
        double result = 0;
        for (Rental rental : getRentals()) {
            result += rental.getCharge();
        }
        return result;
    }

    int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : getRentals()) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}