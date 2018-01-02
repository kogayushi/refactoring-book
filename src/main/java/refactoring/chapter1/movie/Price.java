package refactoring.chapter1.movie;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}
