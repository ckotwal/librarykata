package bnymellon.codekata.librarykata.domain;


/**
 * Class representing a book
 */
public class Book {
    // Unique Key
    private String isbn;
    private String author;
    private String title;
    private double price;
    private long quantitySold;

    public Book(String isbn, String author, String title, double price, long quantitySold) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
        this.quantitySold = quantitySold;
    }


    public String getAuthor() {
        return author;
    }


    public String getTitle() {
        return title;
    }


    public double getPrice() {
        return price;
    }


    public long getQuantitySold() {
        return quantitySold;
    }


    public String getIsbn() {
        return isbn;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (Double.compare(book.price, price) != 0) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (!author.equals(book.author)) return false;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + author.hashCode();
        result = 31 * result + title.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
