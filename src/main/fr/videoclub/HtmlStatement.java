package fr.videoclub;

public class HtmlStatement extends Statement {

    public HtmlStatement(Customer customer) {
        super(customer);
    }

    @Override
    protected String footerLineFirst() {
        return "<P>You owe <EM>" + String.valueOf(customer.getTotalCharges()) + "</EM><P>\n";
    }

    @Override
    protected String footerLineSecond() {
        return "On this rental you earned <EM>" +
                String.valueOf(customer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
    }

    @Override
    protected String eachRentalString(Rental rental) {
        return rental.getMovie().getTitle() + ": " +
                String.valueOf(rental.getCharge()) + "<BR>\n";
    }

    @Override
    protected String headerString() {
        String result = "<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">";
        result += "<H1>Rentals for <EM>" + customer.getName() + "</EM></ H1><P>\n";
        return result;
    }
}