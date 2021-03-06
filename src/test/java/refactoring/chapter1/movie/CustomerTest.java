package refactoring.chapter1.movie;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    @Test
    public void testStatementWithRegularFor2Days() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.REGULAR), 2));
        String actual = sut.statement();

        String expected = "Rental Record for risa\n" +
                "\tspider man\t2.0\t\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertThat(actual, is(expected));
    }

    @Test
    public void testStatementWithRegularFor3Days() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.REGULAR), 3));
        String actual = sut.statement();

        String expected = "Rental Record for risa\n" +
                "\tspider man\t3.5\t\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertThat(actual, is(expected));
    }

    @Test
    public void testStatementWithNewReleaseFor1Days() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.NEW_RELEASE), 1));
        String actual = sut.statement();

        String expected = "Rental Record for risa\n" +
                "\tspider man\t3.0\t\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertThat(actual, is(expected));
    }

    @Test
    public void testStatementWithNewReleaseFor3Days() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.NEW_RELEASE), 3));
        String actual = sut.statement();

        String expected = "Rental Record for risa\n" +
                "\tspider man\t9.0\t\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        assertThat(actual, is(expected));
    }

    @Test
    public void testStatementWithChildrensFor3Days() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.CHILDRENS), 3));
        String actual = sut.statement();

        String expected = "Rental Record for risa\n" +
                "\tspider man\t1.5\t\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        assertThat(actual, is(expected));
    }

    @Test
    public void testStatementWithChildrensFor4Days() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.CHILDRENS), 4));
        String actual = sut.statement();

        String expected = "Rental Record for risa\n" +
                "\tspider man\t3.0\t\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertThat(actual, is(expected));
    }

    @Test
    public void testStatementWithSevral() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.REGULAR), 2));
        sut.addRental(new Rental(new Movie("mighty thor", Movie.NEW_RELEASE), 3));
        String actual = sut.statement();

        String expected = "Rental Record for risa\n" +
                "\tspider man\t2.0\t\n" +
                "\tmighty thor\t9.0\t\n" +
                "Amount owed is 11.0\n" +
                "You earned 3 frequent renter points";
        assertThat(actual, is(expected));
    }

    @Test
    public void testHtmlStatementWithSevral() {
        Customer sut = new Customer("risa");
        sut.addRental(new Rental(new Movie("spider man", Movie.REGULAR), 2));
        sut.addRental(new Rental(new Movie("mighty thor", Movie.NEW_RELEASE), 3));
        String actual = sut.htmlStatement();

        String expected = "<H1>Rental Record for <EM>risa</EM></H1><P>\n" +
                "spider man:2.0<BR>\n" +
                "mighty thor:9.0<BR>\n" +
                "<P>You owe <EM>11.0</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P>";
        assertThat(actual, is(expected));
    }
}
