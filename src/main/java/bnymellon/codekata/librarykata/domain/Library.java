package bnymellon.codekata.librarykata.domain;

import java.util.List;
import java.util.Map;

/**
 * Created by XBBND4K on 8/16/2017.
 */
public interface Library {
    Library addBook(Book book);

    List<String> retrieveOrderedIsbns();

    List<Book> retrieveBooksWrittenBy(String author);

    Map<String, List<Book>> retrieveAllBooksByAuthor();

    String retriveAmazonRanking(String isbn);

    Map<String, Long> retrieveQuantitySoldByAuthor();

    List<String> retrieveAuthorsWithSalesGreaterThan(double salesAmount);

    boolean contains(Book newBook);

    void clear();
}
