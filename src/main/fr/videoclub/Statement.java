package fr.videoclub;

public abstract class Statement {
    protected final Customer customer;

    public Statement(Customer customer) {
        this.customer = customer;
    }

    public String value() {
        String result = headerString();
        for (Rental rental : customer.getRentals()) {
            result += eachRentalString(rental);
        }
        result += footerLineFirst();
        result += footerLineSecond();
        return result;
    }

    protected abstract String footerLineFirst();

    protected abstract String footerLineSecond();

    protected abstract String eachRentalString(Rental rental);

    protected abstract String headerString();
}
