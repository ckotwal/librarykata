package bnymellon.codekata.librarykata.domain;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by XBBND4K on 8/16/2017.
 */
public class TestObjectMother {

    public static final String AUTHOR1 = "Ludlum";
    public static final String AUTHOR2 = "Silva";
    public static final Book BOOK3 = new Book("5", AUTHOR2, "English Assasin", 9.5, 2000);
    public static final String AUTHOR3 = "Christie";
    public static final Book BOOK4 = new Book("4", AUTHOR3, "N or M", 10, 1000);
    public static final String TITLE1 = "Chancellor Manuscript";
    public static final Book BOOK1 = new Book("1", AUTHOR1, TITLE1, 10.5, 500);
    public static final String TITLE2 = "Osterman Weekend";
    public static final Book BOOK2 = new Book("2", AUTHOR1, TITLE2, 12, 1000);

    public static Library initializeLibrary(Library library) {
        library.addBook(TestObjectMother.BOOK1);
        library.addBook(TestObjectMother.BOOK2);
        library.addBook(TestObjectMother.BOOK3);
        library.addBook(TestObjectMother.BOOK4);
        return library;
    }


}
