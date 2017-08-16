package bnymellon.codekata.librarykata.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by XBBND4K on 8/16/2017.
 */
public class NewLibraryTest {

    Library oldLibrary = new OldLibrary(new ArrayList<Book>());
    Library newLibrary = new NewLibrary(new ArrayList<Book>());

    @Before
    public void setup() {
        oldLibrary = TestObjectMother.initializeLibrary(oldLibrary);
        newLibrary = TestObjectMother.initializeLibrary(newLibrary);
    }

    @After
    public void teardown() {
        oldLibrary.clear();
        newLibrary.clear();
    }

    @Test
    public void addBook() {
        final Book newBook = new Book("1", "Wodehouse", "Jeeves", 5, 5000);
        newLibrary.addBook(newBook);
        assertEquals(true, newLibrary.contains(newBook));
    }

    @Test
    public void retrieveOrderedIsbns() {
        assertEquals(oldLibrary.retrieveOrderedIsbns(),
                    newLibrary.retrieveOrderedIsbns());
    }

    @Test
    public void retrieveBooksWrittenBy() {
        assertEquals(oldLibrary.retrieveBooksWrittenBy(TestObjectMother.AUTHOR1),
                    newLibrary.retrieveBooksWrittenBy(TestObjectMother.AUTHOR1));
    }

    @Test
    public void retrieveAllBooksByAuthor() throws Exception {
        assertEquals(oldLibrary.retrieveAllBooksByAuthor(),
                    newLibrary.retrieveAllBooksByAuthor());
    }

    @Test
    public void retriveAmazonRanking() throws Exception {
        assertEquals(oldLibrary.retriveAmazonRanking("1"),
                    newLibrary.retriveAmazonRanking("1"));
    }

    @Test
    public void retrieveQuantitySoldByAuthor() throws Exception {
        assertEquals(oldLibrary.retrieveQuantitySoldByAuthor(),
                    newLibrary.retrieveQuantitySoldByAuthor());
    }

    @Test
    public void retrieveAuthorsWithSalesGreaterThan() throws Exception {
        assertEquals(oldLibrary.retrieveAuthorsWithSalesGreaterThan(9000),
                    newLibrary.retrieveAuthorsWithSalesGreaterThan(9000));

    }


}