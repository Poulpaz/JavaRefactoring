package fr.videoclub;

public class Movie {

    private String title;
    private Category category;

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return category.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return category.getFrequentRenterPoints(daysRented);
    }
}
