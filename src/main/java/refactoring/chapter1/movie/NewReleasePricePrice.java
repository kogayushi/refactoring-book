package refactoring.chapter1.movie;

public class NewReleasePricePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
