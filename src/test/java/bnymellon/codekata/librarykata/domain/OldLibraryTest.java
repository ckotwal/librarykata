package bnymellon.codekata.librarykata.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by XBBND4K on 8/16/2017.
 */
public class OldLibraryTest {

    Library oldLibrary = new OldLibrary(new ArrayList<Book>());

    @Before
    public void setup() {
        oldLibrary = TestObjectMother.initializeLibrary(oldLibrary);
    }

    @After
    public void teardown() {
        oldLibrary.clear();
    }

    @Test
    public void addBook()  {
        final Book newBook = new Book("1", "Wodehouse", "Jeeves", 5, 5000);
        oldLibrary.addBook(newBook);
        assertEquals(true, oldLibrary.contains(newBook));
    }

    @Test
    public void retrieveOrderedIsbns() {
        assertEquals(asList("1", "2", "4", "5"),oldLibrary.retrieveOrderedIsbns());
    }

    @Test
    public void retrieveBooksWrittenBy()  {
        assertEquals(asList(TestObjectMother.BOOK1, TestObjectMother.BOOK2), oldLibrary.retrieveBooksWrittenBy(TestObjectMother.AUTHOR1));
    }

    @Test
    public void retrieveAllBooksByAuthor() throws Exception {
        final Map<String, List<Book>> booksByAuthor = oldLibrary.retrieveAllBooksByAuthor();
        assertEquals("Size is different", 3, booksByAuthor.size());
        assertEquals(asList(TestObjectMother.BOOK1, TestObjectMother.BOOK2), booksByAuthor.get(TestObjectMother.AUTHOR1));
        assertEquals(asList(TestObjectMother.BOOK3), booksByAuthor.get(TestObjectMother.AUTHOR2));
        assertEquals(asList(TestObjectMother.BOOK4), booksByAuthor.get(TestObjectMother.AUTHOR3));
    }

    @Test
    public void retriveAmazonRanking() throws Exception {
        assertEquals("1", oldLibrary.retriveAmazonRanking("1"));
    }

    @Test
    public void retrieveQuantitySoldByAuthor() throws Exception {
        final Map<String, Long> quantitySoldByAuthor = oldLibrary.retrieveQuantitySoldByAuthor();
        assertEquals("Size is different", 3, quantitySoldByAuthor.size());
        assertEquals(1500L, quantitySoldByAuthor.get(TestObjectMother.AUTHOR1).longValue());
        assertEquals(2000L, quantitySoldByAuthor.get(TestObjectMother.AUTHOR2).longValue());
        assertEquals(1000L, quantitySoldByAuthor.get(TestObjectMother.AUTHOR3).longValue());
    }

    @Test
    public void retrieveAuthorsWithSalesGreaterThan() throws Exception {
        final List<String> authors0 = oldLibrary.retrieveAuthorsWithSalesGreaterThan(9000);
        assertEquals(3, authors0.size());

        final List<String> authors2 = oldLibrary.retrieveAuthorsWithSalesGreaterThan(18500);
        assertEquals(1, authors2.size());

        authors2.contains(TestObjectMother.AUTHOR2);


    }


}