package refactoring.chapter1.movie;

public class RegularPricePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
