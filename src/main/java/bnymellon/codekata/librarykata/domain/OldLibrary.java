package bnymellon.codekata.librarykata.domain;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by XBBND4K on 8/16/2017.
 */
public class OldLibrary implements Library {

    private List<Book> books = new ArrayList<>();
    private ConcurrentMap<String, String> amazonRanking = new ConcurrentHashMap<>();

    public OldLibrary(List<Book> books) {
        if (books == null) throw new NullPointerException("Null books not allowed");
        this.books = books;
    }

    /**
     * Add a book to the library
     * @param book Non null book
     * @return Library instance for a fluent interface
     */
    @Override
    public Library addBook(Book book) {
        this.books.add(book);
        return this;
    }

    /**
     * Retrieved the list of isbns in the library in sorted order
     * @return a sorted list of isbns
     */
    @Override
    public List<String> retrieveOrderedIsbns() {
        List<String> isbns = new ArrayList<>();
        for (Book book : books) {
            isbns.add(book.getIsbn());
        }
        Collections.sort(isbns);
        return isbns;
    }

    /**
     * Retrieves all the books written by a certain author
     * @param author the author to filter the library by
     * @return list of books
     */
    @Override
    public List<Book> retrieveBooksWrittenBy(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author))
                authorBooks.add(book);
        }
        return authorBooks;
    }

    /**
     * Returns a map of all authors as key, with the list of books they have written as the value
     * @return The above map
     */
    @Override
    public Map<String, List<Book>> retrieveAllBooksByAuthor() {
        Map<String, List<Book>> booksByAuthor = new HashMap<>();
        for (Book book : books) {
            final String author = book.getAuthor();
            if(booksByAuthor.get(author) == null) {
                booksByAuthor.put(author, new ArrayList<Book>());
            }
            booksByAuthor.get(author).add(book);
        }
        return booksByAuthor;
    }

    /**
     * This simulates an expensive call to an external service to populate a map. Subsequent invocations
     * will access the cached value
     * Java 8 offers a more elegant way of doing this using the computeIfAbsent method
     * @param isbn
     * @return The value of the call to the expensive/external service
     */
    @Override
    public String retriveAmazonRanking(String isbn) {
        if(amazonRanking.get(isbn) == null) {
            amazonRanking.put(isbn, AmazonWebService.determineRating(isbn));
        }
        return amazonRanking.get(isbn);

    }

    /**
     * Returns the quantity of books sold per author
     * @return Map containing the author name and the number of books sold
     */
    @Override
    public Map<String, Long> retrieveQuantitySoldByAuthor() {
        Map<String, Long> quantityByAuthor = new HashMap<>();
        for (Book book : books) {
            final String author = book.getAuthor();
            if(quantityByAuthor.get(author) == null) {
                quantityByAuthor.put(author, book.getQuantitySold());
            }
            else {
                quantityByAuthor.put(author, book.getQuantitySold() + quantityByAuthor.get(author));
            }
        }

        return quantityByAuthor;

    }

    /**
     * Retrieves the authors who have sold books more than a certain salesAmount
     * @param salesAmount The lower limit for the sales amount
     * @return The list of authors who have sales greater than the passed in salesAmount
     */
    @Override
    public List<String> retrieveAuthorsWithSalesGreaterThan(double salesAmount) {
        Map<String, Double> salesByAuthor = determineSalesByAuthor();
        return filterSalesByAmount(salesByAuthor, salesAmount);
    }

    private List<String> filterSalesByAmount(Map<String, Double> salesByAuthor, double salesAmount) {
        List<String> authors = new ArrayList<>();
        final Set<Map.Entry<String, Double>> entries = salesByAuthor.entrySet();
        for (Iterator<Map.Entry<String, Double>> iterator = entries.iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Double> next =  iterator.next();
            if(next.getValue() > salesAmount) {
                authors.add(next.getKey());
            }
        }
        return authors;
    }

    private Map<String, Double> determineSalesByAuthor() {
        Map<String, Double> salesByAuthor = new HashMap<>();
        for (Book book : books) {
            final String author = book.getAuthor();
            if(salesByAuthor.get(author) == null) {
                salesByAuthor.put(author, bookSales(book));
            }
            else {
                salesByAuthor.put(author, bookSales(book) + salesByAuthor.get(author));
            }
        }
        return salesByAuthor;
    }

    private double bookSales(Book book) {
        return book.getQuantitySold() * book.getPrice();
    }

    /**
     * Check whether the library contains a certain book
     * @param newBook the book to check for
     * @return true if the library contains the book, false otherwise
     */
    @Override
    public boolean contains(Book newBook) {
        return books.contains(newBook);
    }

    @Override
    public void clear() {
        books.clear();
        amazonRanking.clear();
    }
}
