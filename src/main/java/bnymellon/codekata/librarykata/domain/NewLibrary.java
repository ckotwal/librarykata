package bnymellon.codekata.librarykata.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by XBBND4K on 8/16/2017.
 */
public class NewLibrary implements Library {

    private List<Book> books = new ArrayList<>();
    private ConcurrentMap<String, String> amazonRanking = new ConcurrentHashMap<>();

    public NewLibrary(ArrayList<Book> books) {
        if (books == null) throw new NullPointerException("Null books not allowed");
        this.books = books;

    }

    @Override
    public Library addBook(Book book) {
        this.books.add(book);
        return this;
    }

    @Override
    public List<String> retrieveOrderedIsbns() {
        return null;
    }

    @Override
    public List<Book> retrieveBooksWrittenBy(String author) {
        return null;
    }

    @Override
    public Map<String, List<Book>> retrieveAllBooksByAuthor() {
        return null;
    }

    @Override
    public String retriveAmazonRanking(String isbn) {
        return null;
    }

    @Override
    public Map<String, Long> retrieveQuantitySoldByAuthor() {
        return null;
    }

    @Override
    public List<String> retrieveAuthorsWithSalesGreaterThan(double salesAmount) {
        return null;
    }

    @Override
    public boolean contains(Book newBook) {
        return books.contains(newBook);
    }

    @Override
    public void clear() {

    }
}
